package com.estate.real.service.impl;

import com.estate.real.Repository.inf.AccountRepository;
import com.estate.real.service.inf.IPFSService;
import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class IPFSServiceImpl implements IPFSService {

    public static IPFS ipfs;

    @Autowired
    AccountRepository accountRepository;

    @PostConstruct
    public void onStart(){
        ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");
    }

    @Override
    public String uploadImage(byte[] arrByte){
        String result = "";
        try {
//            IPFS ipfs = init(MyIPFS.URL_API);
            NamedStreamable.ByteArrayWrapper bytearray = new NamedStreamable.ByteArrayWrapper(arrByte);
            MerkleNode response = ipfs.add(bytearray).get(0);
            System.out.println("Hash image upload (base 58): " + response.hash.toBase58());
            result = response.hash.toBase58();
        } catch (IOException ex) {
            System.out.println("Loi hash image upload");
            result = "";
            throw new RuntimeException("Error whilst communicating with the IPFS node", ex);
        }
        return result;
    }

    @Override
    public boolean pinHashImage(String hashImage){
        boolean result = false;
//        IPFS ipfs = MyIPFS.init(MyIPFS.URL_API);
        try {
//            String hash = "QRFi3dgfSVKpc1B9idTEuN3cBScszNHP9sfyMUF7F8ff5o"; // Hash of a file
            Multihash multihash = Multihash.fromBase58(hashImage);
            ipfs.pin.add(multihash);
            result = true;
            Map<String,Object> map = new HashMap<>();
            map.put("img", "https://ipfs.io/ipfs/" + multihash.toString());
            accountRepository.updateImage("123", map);
            System.out.println("Pin hash thanh cong");
        } catch (IOException ex) {
            result = false;
            System.out.println("Loi pin hash image");
            throw new RuntimeException("Error whilst communicating with the IPFS node", ex);
        }
        return result;
    }
}

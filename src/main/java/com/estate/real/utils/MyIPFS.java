package com.estate.real.utils;

import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multibase.Base58;
import io.ipfs.multihash.Multihash;

import java.io.IOException;

public class MyIPFS {
    public static final String URL_API = "/ip4/127.0.0.1/tcp/5001";

    public static IPFS init(String urlApi){
        IPFS ipfs = new IPFS(MyIPFS.URL_API);
        return ipfs;
    }

    public static String uploadImage(byte[] arrByte){
        String result = "";
        try {
            IPFS ipfs = init(MyIPFS.URL_API);
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

    public static boolean pinHashImage(String hashImage){
        boolean result = false;
        IPFS ipfs = MyIPFS.init(MyIPFS.URL_API);
        try {
//            String hash = "QRFi3dgfSVKpc1B9idTEuN3cBScszNHP9sfyMUF7F8ff5o"; // Hash of a file
            Multihash multihash = Multihash.fromBase58(hashImage);
            ipfs.pin.add(multihash);
            result = true;
            System.out.println("Pin hash thanh cong");
        } catch (IOException ex) {
            result = false;
            System.out.println("Loi pin hash image");
            throw new RuntimeException("Error whilst communicating with the IPFS node", ex);
        }
        return result;
    }
}

package com.estate.real.contract;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple8;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class ManageRealEsate extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060006001819055506126b8806100686000396000f3fe6080604052600436106100705760003560e01c80635b207bdf1161004e5780635b207bdf14610a8157806382f557ae14610ae65780638da5cb5b14610b11578063b3f40d6a14610b6857610070565b806305efe9c7146100725780634b3ddeaa1461039c5780634e995f6e14610757575b005b34801561007e57600080fd5b506100cb6004803603604081101561009557600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610bdb565b604051808973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001806020018060200180602001806020018881526020018060200187810387528e818151815260200191508051906020019080838360005b8381101561015757808201518184015260208101905061013c565b50505050905090810190601f1680156101845780820380516001836020036101000a031916815260200191505b5087810386528d818151815260200191508051906020019080838360005b838110156101bd5780820151818401526020810190506101a2565b50505050905090810190601f1680156101ea5780820380516001836020036101000a031916815260200191505b5087810385528c818151815260200191508051906020019080838360005b83811015610223578082015181840152602081019050610208565b50505050905090810190601f1680156102505780820380516001836020036101000a031916815260200191505b5087810384528b818151815260200191508051906020019080838360005b8381101561028957808201518184015260208101905061026e565b50505050905090810190601f1680156102b65780820380516001836020036101000a031916815260200191505b5087810383528a818151815260200191508051906020019080838360005b838110156102ef5780820151818401526020810190506102d4565b50505050905090810190601f16801561031c5780820380516001836020036101000a031916815260200191505b50878103825288818151815260200191508051906020019080838360005b8381101561035557808201518184015260208101905061033a565b50505050905090810190601f1680156103825780820380516001836020036101000a031916815260200191505b509e50505050505050505050505050505060405180910390f35b3480156103a857600080fd5b50610755600480360360c08110156103bf57600080fd5b81019080803590602001906401000000008111156103dc57600080fd5b8201836020820111156103ee57600080fd5b8035906020019184600183028401116401000000008311171561041057600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561047357600080fd5b82018360208201111561048557600080fd5b803590602001918460018302840111640100000000831117156104a757600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561050a57600080fd5b82018360208201111561051c57600080fd5b8035906020019184600183028401116401000000008311171561053e57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001906401000000008111156105a157600080fd5b8201836020820111156105b357600080fd5b803590602001918460018302840111640100000000831117156105d557600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561063857600080fd5b82018360208201111561064a57600080fd5b8035906020019184600183028401116401000000008311171561066c57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001906401000000008111156106cf57600080fd5b8201836020820111156106e157600080fd5b8035906020019184600183028401116401000000008311171561070357600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050610fed565b005b34801561076357600080fd5b506107b06004803603604081101561077a57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050611290565b604051808973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001806020018060200180602001806020018060200188815260200187810387528e818151815260200191508051906020019080838360005b8381101561083c578082015181840152602081019050610821565b50505050905090810190601f1680156108695780820380516001836020036101000a031916815260200191505b5087810386528d818151815260200191508051906020019080838360005b838110156108a2578082015181840152602081019050610887565b50505050905090810190601f1680156108cf5780820380516001836020036101000a031916815260200191505b5087810385528c818151815260200191508051906020019080838360005b838110156109085780820151818401526020810190506108ed565b50505050905090810190601f1680156109355780820380516001836020036101000a031916815260200191505b5087810384528b818151815260200191508051906020019080838360005b8381101561096e578082015181840152602081019050610953565b50505050905090810190601f16801561099b5780820380516001836020036101000a031916815260200191505b5087810383528a818151815260200191508051906020019080838360005b838110156109d45780820151818401526020810190506109b9565b50505050905090810190601f168015610a015780820380516001836020036101000a031916815260200191505b50878103825289818151815260200191508051906020019080838360005b83811015610a3a578082015181840152602081019050610a1f565b50505050905090810190601f168015610a675780820380516001836020036101000a031916815260200191505b509e50505050505050505050505050505060405180910390f35b348015610a8d57600080fd5b50610ad060048036036020811015610aa457600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506119d7565b6040518082815260200191505060405180910390f35b348015610af257600080fd5b50610afb611b01565b6040518082815260200191505060405180910390f35b348015610b1d57600080fd5b50610b26611b07565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b348015610b7457600080fd5b50610bc160048036036040811015610b8b57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050611b2c565b604051808215151515815260200191505060405180910390f35b60026020528160005260406000208181548110610bf457fe5b9060005260206000209060080201600091509150508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690806001018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610cc75780601f10610c9c57610100808354040283529160200191610cc7565b820191906000526020600020905b815481529060010190602001808311610caa57829003601f168201915b505050505090806002018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610d655780601f10610d3a57610100808354040283529160200191610d65565b820191906000526020600020905b815481529060010190602001808311610d4857829003601f168201915b505050505090806003018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610e035780601f10610dd857610100808354040283529160200191610e03565b820191906000526020600020905b815481529060010190602001808311610de657829003601f168201915b505050505090806004018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610ea15780601f10610e7657610100808354040283529160200191610ea1565b820191906000526020600020905b815481529060010190602001808311610e8457829003601f168201915b505050505090806005018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610f3f5780601f10610f1457610100808354040283529160200191610f3f565b820191906000526020600020905b815481529060010190602001808311610f2257829003601f168201915b505050505090806006015490806007018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610fe35780601f10610fb857610100808354040283529160200191610fe3565b820191906000526020600020905b815481529060010190602001808311610fc657829003601f168201915b5050505050905088565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461104657600080fd5b600180540160018190555061105961253b565b6040518061010001604052803373ffffffffffffffffffffffffffffffffffffffff1681526020018881526020018781526020018481526020018581526020018381526020016001548152602001868152509050600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819080600181540180825580915050906001820390600052602060002090600802016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550602082015181600101908051906020019061117b929190612596565b506040820151816002019080519060200190611198929190612596565b5060608201518160030190805190602001906111b5929190612596565b5060808201518160040190805190602001906111d2929190612596565b5060a08201518160050190805190602001906111ef929190612596565b5060c0820151816006015560e0820151816007019080519060200190611216929190612596565b505050507f2728c9d3205d667bbc0eefdfeda366261b4d021949630c047f3e5834b30611ab33600154604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a150505050505050565b600060608060608060608060006112a561253b565b604051806101000160405280600260008e73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208c815481106112fb57fe5b906000526020600020906008020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001600260008e73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208c8154811061139257fe5b90600052602060002090600802016001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156114375780601f1061140c57610100808354040283529160200191611437565b820191906000526020600020905b81548152906001019060200180831161141a57829003601f168201915b50505050508152602001600260008e73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208c8154811061148b57fe5b90600052602060002090600802016002018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156115305780601f1061150557610100808354040283529160200191611530565b820191906000526020600020905b81548152906001019060200180831161151357829003601f168201915b50505050508152602001600260008e73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208c8154811061158457fe5b90600052602060002090600802016003018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156116295780601f106115fe57610100808354040283529160200191611629565b820191906000526020600020905b81548152906001019060200180831161160c57829003601f168201915b50505050508152602001600260008e73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208c8154811061167d57fe5b90600052602060002090600802016004018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156117225780601f106116f757610100808354040283529160200191611722565b820191906000526020600020905b81548152906001019060200180831161170557829003601f168201915b50505050508152602001600260008e73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208c8154811061177657fe5b90600052602060002090600802016005018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561181b5780601f106117f05761010080835404028352916020019161181b565b820191906000526020600020905b8154815290600101906020018083116117fe57829003601f168201915b50505050508152602001600260008e73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208c8154811061186f57fe5b9060005260206000209060080201600601548152602001600260008e73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208c815481106118d057fe5b90600052602060002090600802016007018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156119755780601f1061194a57610100808354040283529160200191611975565b820191906000526020600020905b81548152906001019060200180831161195857829003601f168201915b50505050508152509050806000015181602001518260400151836080015184606001518560a001518660e001518760c0015186965085955084945083935082925081915098509850985098509850985098509850509295985092959890939650565b600080600090506000600260008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002080549050905060008090505b81811015611af657600073ffffffffffffffffffffffffffffffffffffffff16600260008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208281548110611a9557fe5b906000526020600020906008020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614611ae9578260010192505b8080600101915050611a2b565b508192505050919050565b60015481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600080600090505b600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208054905081101561252f5782600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208281548110611bc957fe5b906000526020600020906008020160060154141561252257611be961253b565b6040518061010001604052808673ffffffffffffffffffffffffffffffffffffffff168152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208481548110611c5b57fe5b90600052602060002090600802016001018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611d005780601f10611cd557610100808354040283529160200191611d00565b820191906000526020600020905b815481529060010190602001808311611ce357829003601f168201915b50505050508152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208481548110611d5457fe5b90600052602060002090600802016002018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611df95780601f10611dce57610100808354040283529160200191611df9565b820191906000526020600020905b815481529060010190602001808311611ddc57829003601f168201915b50505050508152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208481548110611e4d57fe5b90600052602060002090600802016003018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611ef25780601f10611ec757610100808354040283529160200191611ef2565b820191906000526020600020905b815481529060010190602001808311611ed557829003601f168201915b50505050508152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208481548110611f4657fe5b90600052602060002090600802016004018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611feb5780601f10611fc057610100808354040283529160200191611feb565b820191906000526020600020905b815481529060010190602001808311611fce57829003601f168201915b50505050508152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020848154811061203f57fe5b90600052602060002090600802016005018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156120e45780601f106120b9576101008083540402835291602001916120e4565b820191906000526020600020905b8154815290600101906020018083116120c757829003601f168201915b50505050508152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020848154811061213857fe5b9060005260206000209060080201600601548152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020848154811061219957fe5b90600052602060002090600802016007018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561223e5780601f106122135761010080835404028352916020019161223e565b820191906000526020600020905b81548152906001019060200180831161222157829003601f168201915b50505050508152509050600260008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819080600181540180825580915050906001820390600052602060002090600802016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506020820151816001019080519060200190612316929190612596565b506040820151816002019080519060200190612333929190612596565b506060820151816003019080519060200190612350929190612596565b50608082015181600401908051906020019061236d929190612596565b5060a082015181600501908051906020019061238a929190612596565b5060c0820151816006015560e08201518160070190805190602001906123b1929190612596565b50505050600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002082815481106123ff57fe5b9060005260206000209060080201600080820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff02191690556001820160006124459190612616565b6002820160006124559190612616565b6003820160006124659190612616565b6004820160006124759190612616565b6005820160006124859190612616565b600682016000905560078201600061249d9190612616565b5050600160008154809291906001900391905055508473ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef866040518082815260200191505060405180910390a3600192505050612535565b8080600101915050611b34565b50600090505b92915050565b604051806101000160405280600073ffffffffffffffffffffffffffffffffffffffff168152602001606081526020016060815260200160608152602001606081526020016060815260200160008152602001606081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106125d757805160ff1916838001178555612605565b82800160010185558215612605579182015b828111156126045782518255916020019190600101906125e9565b5b509050612612919061265e565b5090565b50805460018160011615610100020316600290046000825580601f1061263c575061265b565b601f01602090049060005260206000209081019061265a919061265e565b5b50565b61268091905b8082111561267c576000816000905550600101612664565b5090565b9056fea265627a7a72315820ba6e47beb93e4f9d7f259b4d10fee4861e29cc368538e55a0fa72899b00d255564736f6c63430005100032";

    public static final String FUNC___OWNEDLANDS = "__ownedLands";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_TOTALLANDSCOUNTER = "totalLandsCounter";

    public static final String FUNC_ADDLAND = "addLand";

    public static final String FUNC_TRANSFERLAND = "transferLand";

    public static final String FUNC_GETLANDBYADDRESS = "getLandByAddress";

    public static final String FUNC_GETNOOFLAND = "getNoOfLand";

    public static final Event ADD_EVENT = new Event("Add", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event PAY_EVENT = new Event("Pay", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    protected ManageRealEsate(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ManageRealEsate(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RemoteCall<ManageRealEsate> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ManageRealEsate.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ManageRealEsate> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ManageRealEsate.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public List<AddEventResponse> getAddEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADD_EVENT, transactionReceipt);
        ArrayList<AddEventResponse> responses = new ArrayList<AddEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddEventResponse typedResponse = new AddEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._landID = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<AddEventResponse> addEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, AddEventResponse>() {
            @Override
            public AddEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADD_EVENT, log);
                AddEventResponse typedResponse = new AddEventResponse();
                typedResponse.log = log;
                typedResponse._owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._landID = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<AddEventResponse> addEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADD_EVENT));
        return addEventObservable(filter);
    }

    public List<PayEventResponse> getPayEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PAY_EVENT, transactionReceipt);
        ArrayList<PayEventResponse> responses = new ArrayList<PayEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PayEventResponse typedResponse = new PayEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._landId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<PayEventResponse> payEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, PayEventResponse>() {
            @Override
            public PayEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PAY_EVENT, log);
                PayEventResponse typedResponse = new PayEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._landId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<PayEventResponse> payEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PAY_EVENT));
        return payEventObservable(filter);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._landId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferEventResponse> transferEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._landId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<TransferEventResponse> transferEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventObservable(filter);
    }

    public RemoteCall<Tuple8<String, String, String, String, String, String, BigInteger, String>> __ownedLands(String param0, BigInteger param1) {
        final Function function = new Function(FUNC___OWNEDLANDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple8<String, String, String, String, String, String, BigInteger, String>>(
                new Callable<Tuple8<String, String, String, String, String, String, BigInteger, String>>() {
                    @Override
                    public Tuple8<String, String, String, String, String, String, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple8<String, String, String, String, String, String, BigInteger, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue(), 
                                (String) results.get(7).getValue());
                    }
                });
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> totalLandsCounter() {
        final Function function = new Function(FUNC_TOTALLANDSCOUNTER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> addLand(String _district, String _street, String _pathImage, String _cost, String _ward, String _description) {
        final Function function = new Function(
                FUNC_ADDLAND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_district), 
                new org.web3j.abi.datatypes.Utf8String(_street), 
                new org.web3j.abi.datatypes.Utf8String(_pathImage), 
                new org.web3j.abi.datatypes.Utf8String(_cost), 
                new org.web3j.abi.datatypes.Utf8String(_ward), 
                new org.web3j.abi.datatypes.Utf8String(_description)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferLand(String _landBuyer, BigInteger _landID) {
        final Function function = new Function(
                FUNC_TRANSFERLAND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_landBuyer), 
                new org.web3j.abi.datatypes.generated.Uint256(_landID)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple8<String, String, String, String, String, String, String, BigInteger>> getLandByAddress(String _landHolder, BigInteger _index) {
        final Function function = new Function(FUNC_GETLANDBYADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_landHolder), 
                new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple8<String, String, String, String, String, String, String, BigInteger>>(
                new Callable<Tuple8<String, String, String, String, String, String, String, BigInteger>>() {
                    @Override
                    public Tuple8<String, String, String, String, String, String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple8<String, String, String, String, String, String, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (String) results.get(6).getValue(), 
                                (BigInteger) results.get(7).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> getNoOfLand(String _landHolder) {
        final Function function = new Function(FUNC_GETNOOFLAND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_landHolder)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static ManageRealEsate load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ManageRealEsate(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static ManageRealEsate load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ManageRealEsate(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class AddEventResponse {
        public Log log;

        public String _owner;

        public BigInteger _landID;
    }

    public static class PayEventResponse {
        public Log log;

        public String _from;

        public BigInteger _value;

        public BigInteger _landId;
    }

    public static class TransferEventResponse {
        public Log log;

        public String _from;

        public String _to;

        public BigInteger _landId;
    }
}

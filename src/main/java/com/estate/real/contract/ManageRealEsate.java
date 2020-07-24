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
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple9;
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
    private static final String BINARY = "0x608060405234801561001057600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600181905550612889806100686000396000f3fe6080604052600436106100705760003560e01c80635b207bdf1161004e5780635b207bdf14610ab857806382f557ae14610b1d5780638da5cb5b14610b48578063b3f40d6a14610b9f57610070565b806305efe9c7146100725780632fcab102146103b15780634e995f6e14610779575b005b34801561007e57600080fd5b506100cb6004803603604081101561009557600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610c12565b604051808a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001806020018060200180602001806020018981526020018060200188600281111561012b57fe5b60ff16815260200187810387528f818151815260200191508051906020019080838360005b8381101561016b578082015181840152602081019050610150565b50505050905090810190601f1680156101985780820380516001836020036101000a031916815260200191505b5087810386528e818151815260200191508051906020019080838360005b838110156101d15780820151818401526020810190506101b6565b50505050905090810190601f1680156101fe5780820380516001836020036101000a031916815260200191505b5087810385528d818151815260200191508051906020019080838360005b8381101561023757808201518184015260208101905061021c565b50505050905090810190601f1680156102645780820380516001836020036101000a031916815260200191505b5087810384528c818151815260200191508051906020019080838360005b8381101561029d578082015181840152602081019050610282565b50505050905090810190601f1680156102ca5780820380516001836020036101000a031916815260200191505b5087810383528b818151815260200191508051906020019080838360005b838110156103035780820151818401526020810190506102e8565b50505050905090810190601f1680156103305780820380516001836020036101000a031916815260200191505b50878103825289818151815260200191508051906020019080838360005b8381101561036957808201518184015260208101905061034e565b50505050905090810190601f1680156103965780820380516001836020036101000a031916815260200191505b509f5050505050505050505050505050505060405180910390f35b3480156103bd57600080fd5b50610777600480360360e08110156103d457600080fd5b81019080803590602001906401000000008111156103f157600080fd5b82018360208201111561040357600080fd5b8035906020019184600183028401116401000000008311171561042557600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561048857600080fd5b82018360208201111561049a57600080fd5b803590602001918460018302840111640100000000831117156104bc57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561051f57600080fd5b82018360208201111561053157600080fd5b8035906020019184600183028401116401000000008311171561055357600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001906401000000008111156105b657600080fd5b8201836020820111156105c857600080fd5b803590602001918460018302840111640100000000831117156105ea57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561064d57600080fd5b82018360208201111561065f57600080fd5b8035906020019184600183028401116401000000008311171561068157600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001906401000000008111156106e457600080fd5b8201836020820111156106f657600080fd5b8035906020019184600183028401116401000000008311171561071857600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803560ff169060200190929190505050611037565b005b34801561078557600080fd5b506107d26004803603604081101561079c57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050611316565b604051808a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001806020018060200180602001806020018060200189600281111561082c57fe5b60ff16815260200188815260200187810387528f818151815260200191508051906020019080838360005b83811015610872578082015181840152602081019050610857565b50505050905090810190601f16801561089f5780820380516001836020036101000a031916815260200191505b5087810386528e818151815260200191508051906020019080838360005b838110156108d85780820151818401526020810190506108bd565b50505050905090810190601f1680156109055780820380516001836020036101000a031916815260200191505b5087810385528d818151815260200191508051906020019080838360005b8381101561093e578082015181840152602081019050610923565b50505050905090810190601f16801561096b5780820380516001836020036101000a031916815260200191505b5087810384528c818151815260200191508051906020019080838360005b838110156109a4578082015181840152602081019050610989565b50505050905090810190601f1680156109d15780820380516001836020036101000a031916815260200191505b5087810383528b818151815260200191508051906020019080838360005b83811015610a0a5780820151818401526020810190506109ef565b50505050905090810190601f168015610a375780820380516001836020036101000a031916815260200191505b5087810382528a818151815260200191508051906020019080838360005b83811015610a70578082015181840152602081019050610a55565b50505050905090810190601f168015610a9d5780820380516001836020036101000a031916815260200191505b509f5050505050505050505050505050505060405180910390f35b348015610ac457600080fd5b50610b0760048036036020811015610adb57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611adf565b6040518082815260200191505060405180910390f35b348015610b2957600080fd5b50610b32611c09565b6040518082815260200191505060405180910390f35b348015610b5457600080fd5b50610b5d611c0f565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b348015610bab57600080fd5b50610bf860048036036040811015610bc257600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050611c34565b604051808215151515815260200191505060405180910390f35b60026020528160005260406000208181548110610c2b57fe5b9060005260206000209060090201600091509150508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690806001018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610cfe5780601f10610cd357610100808354040283529160200191610cfe565b820191906000526020600020905b815481529060010190602001808311610ce157829003601f168201915b505050505090806002018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610d9c5780601f10610d7157610100808354040283529160200191610d9c565b820191906000526020600020905b815481529060010190602001808311610d7f57829003601f168201915b505050505090806003018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610e3a5780601f10610e0f57610100808354040283529160200191610e3a565b820191906000526020600020905b815481529060010190602001808311610e1d57829003601f168201915b505050505090806004018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610ed85780601f10610ead57610100808354040283529160200191610ed8565b820191906000526020600020905b815481529060010190602001808311610ebb57829003601f168201915b505050505090806005018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610f765780601f10610f4b57610100808354040283529160200191610f76565b820191906000526020600020905b815481529060010190602001808311610f5957829003601f168201915b505050505090806006015490806007018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561101a5780601f10610fef5761010080835404028352916020019161101a565b820191906000526020600020905b815481529060010190602001808311610ffd57829003601f168201915b5050505050908060080160009054906101000a900460ff16905089565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461109057600080fd5b60018054016001819055506110a36126fa565b6040518061012001604052803373ffffffffffffffffffffffffffffffffffffffff168152602001898152602001888152602001858152602001868152602001848152602001600154815260200187815260200183600281111561110357fe5b8152509050600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819080600181540180825580915050906001820390600052602060002090600902016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010190805190602001906111d6929190612767565b5060408201518160020190805190602001906111f3929190612767565b506060820151816003019080519060200190611210929190612767565b50608082015181600401908051906020019061122d929190612767565b5060a082015181600501908051906020019061124a929190612767565b5060c0820151816006015560e0820151816007019080519060200190611271929190612767565b506101008201518160080160006101000a81548160ff0219169083600281111561129757fe5b02179055505050507f2728c9d3205d667bbc0eefdfeda366261b4d021949630c047f3e5834b30611ab33600154604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a15050505050505050565b600060608060608060608060008061132c6126fa565b604051806101200160405280600260008f73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208d8154811061138257fe5b906000526020600020906009020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001600260008f73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208d8154811061141957fe5b90600052602060002090600902016001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156114be5780601f10611493576101008083540402835291602001916114be565b820191906000526020600020905b8154815290600101906020018083116114a157829003601f168201915b50505050508152602001600260008f73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208d8154811061151257fe5b90600052602060002090600902016002018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156115b75780601f1061158c576101008083540402835291602001916115b7565b820191906000526020600020905b81548152906001019060200180831161159a57829003601f168201915b50505050508152602001600260008f73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208d8154811061160b57fe5b90600052602060002090600902016003018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156116b05780601f10611685576101008083540402835291602001916116b0565b820191906000526020600020905b81548152906001019060200180831161169357829003601f168201915b50505050508152602001600260008f73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208d8154811061170457fe5b90600052602060002090600902016004018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156117a95780601f1061177e576101008083540402835291602001916117a9565b820191906000526020600020905b81548152906001019060200180831161178c57829003601f168201915b50505050508152602001600260008f73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208d815481106117fd57fe5b90600052602060002090600902016005018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156118a25780601f10611877576101008083540402835291602001916118a2565b820191906000526020600020905b81548152906001019060200180831161188557829003601f168201915b50505050508152602001600260008f73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208d815481106118f657fe5b9060005260206000209060090201600601548152602001600260008f73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208d8154811061195757fe5b90600052602060002090600902016007018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156119fc5780601f106119d1576101008083540402835291602001916119fc565b820191906000526020600020905b8154815290600101906020018083116119df57829003601f168201915b50505050508152602001600260008f73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208d81548110611a5057fe5b906000526020600020906009020160080160009054906101000a900460ff166002811115611a7a57fe5b8152509050806000015181602001518260400151836080015184606001518560a001518660e001518761010001518860c00151879750869650859550849450839350829250995099509950995099509950995099509950509295985092959850929598565b600080600090506000600260008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002080549050905060008090505b81811015611bfe57600073ffffffffffffffffffffffffffffffffffffffff16600260008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208281548110611b9d57fe5b906000526020600020906009020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614611bf1578260010192505b8080600101915050611b33565b508192505050919050565b60015481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600080600090505b600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020805490508110156126ee5782600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208281548110611cd157fe5b90600052602060002090600902016006015414156126e157611cf16126fa565b6040518061012001604052808673ffffffffffffffffffffffffffffffffffffffff168152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208481548110611d6357fe5b90600052602060002090600902016001018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611e085780601f10611ddd57610100808354040283529160200191611e08565b820191906000526020600020905b815481529060010190602001808311611deb57829003601f168201915b50505050508152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208481548110611e5c57fe5b90600052602060002090600902016002018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611f015780601f10611ed657610100808354040283529160200191611f01565b820191906000526020600020905b815481529060010190602001808311611ee457829003601f168201915b50505050508152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208481548110611f5557fe5b90600052602060002090600902016003018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611ffa5780601f10611fcf57610100808354040283529160200191611ffa565b820191906000526020600020905b815481529060010190602001808311611fdd57829003601f168201915b50505050508152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020848154811061204e57fe5b90600052602060002090600902016004018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156120f35780601f106120c8576101008083540402835291602001916120f3565b820191906000526020600020905b8154815290600101906020018083116120d657829003601f168201915b50505050508152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020848154811061214757fe5b90600052602060002090600902016005018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156121ec5780601f106121c1576101008083540402835291602001916121ec565b820191906000526020600020905b8154815290600101906020018083116121cf57829003601f168201915b50505050508152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020848154811061224057fe5b9060005260206000209060090201600601548152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002084815481106122a157fe5b90600052602060002090600902016007018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156123465780601f1061231b57610100808354040283529160200191612346565b820191906000526020600020905b81548152906001019060200180831161232957829003601f168201915b50505050508152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020848154811061239a57fe5b906000526020600020906009020160080160009054906101000a900460ff1660028111156123c457fe5b8152509050600260008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819080600181540180825580915050906001820390600052602060002090600902016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506020820151816001019080519060200190612497929190612767565b5060408201518160020190805190602001906124b4929190612767565b5060608201518160030190805190602001906124d1929190612767565b5060808201518160040190805190602001906124ee929190612767565b5060a082015181600501908051906020019061250b929190612767565b5060c0820151816006015560e0820151816007019080519060200190612532929190612767565b506101008201518160080160006101000a81548160ff0219169083600281111561255857fe5b0217905550505050600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002082815481106125aa57fe5b9060005260206000209060090201600080820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff02191690556001820160006125f091906127e7565b60028201600061260091906127e7565b60038201600061261091906127e7565b60048201600061262091906127e7565b60058201600061263091906127e7565b600682016000905560078201600061264891906127e7565b6008820160006101000a81549060ff02191690555050600160008154809291906001900391905055508473ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef866040518082815260200191505060405180910390a36001925050506126f4565b8080600101915050611c3c565b50600090505b92915050565b604051806101200160405280600073ffffffffffffffffffffffffffffffffffffffff168152602001606081526020016060815260200160608152602001606081526020016060815260200160008152602001606081526020016000600281111561276157fe5b81525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106127a857805160ff19168380011785556127d6565b828001600101855582156127d6579182015b828111156127d55782518255916020019190600101906127ba565b5b5090506127e3919061282f565b5090565b50805460018160011615610100020316600290046000825580601f1061280d575061282c565b601f01602090049060005260206000209081019061282b919061282f565b5b50565b61285191905b8082111561284d576000816000905550600101612835565b5090565b9056fea265627a7a7231582010a32f9640c888915acae4bb22c3f86a8e96927dcbadd7db464bb79728c40ca164736f6c63430005100032";

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

    public RemoteCall<Tuple9<String, String, String, String, String, String, BigInteger, String, BigInteger>> __ownedLands(String param0, BigInteger param1) {
        final Function function = new Function(FUNC___OWNEDLANDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}));
        return new RemoteCall<Tuple9<String, String, String, String, String, String, BigInteger, String, BigInteger>>(
                new Callable<Tuple9<String, String, String, String, String, String, BigInteger, String, BigInteger>>() {
                    @Override
                    public Tuple9<String, String, String, String, String, String, BigInteger, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple9<String, String, String, String, String, String, BigInteger, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue(), 
                                (String) results.get(7).getValue(), 
                                (BigInteger) results.get(8).getValue());
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

    public RemoteCall<TransactionReceipt> addLand(String _district, String _street, String _pathImage, String _cost, String _ward, String _description, BigInteger _status) {
        final Function function = new Function(
                FUNC_ADDLAND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_district), 
                new org.web3j.abi.datatypes.Utf8String(_street), 
                new org.web3j.abi.datatypes.Utf8String(_pathImage), 
                new org.web3j.abi.datatypes.Utf8String(_cost), 
                new org.web3j.abi.datatypes.Utf8String(_ward), 
                new org.web3j.abi.datatypes.Utf8String(_description), 
                new org.web3j.abi.datatypes.generated.Uint8(_status)), 
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

    public RemoteCall<Tuple9<String, String, String, String, String, String, String, BigInteger, BigInteger>> getLandByAddress(String _landHolder, BigInteger _index) {
        final Function function = new Function(FUNC_GETLANDBYADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_landHolder), 
                new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple9<String, String, String, String, String, String, String, BigInteger, BigInteger>>(
                new Callable<Tuple9<String, String, String, String, String, String, String, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple9<String, String, String, String, String, String, String, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple9<String, String, String, String, String, String, String, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (String) results.get(6).getValue(), 
                                (BigInteger) results.get(7).getValue(), 
                                (BigInteger) results.get(8).getValue());
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

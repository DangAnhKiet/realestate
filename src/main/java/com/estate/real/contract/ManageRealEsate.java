package  com.estate.real.contract;

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
import org.web3j.tuples.generated.Tuple6;
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
    private static final String BINARY = "0x608060405234801561001057600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600181905550611d3b806100686000396000f3fe608060405234801561001057600080fd5b506004361061007d5760003560e01c806382f557ae1161005b57806382f557ae146105645780638da5cb5b14610582578063b3f40d6a146105cc578063e7bc19f0146106325761007d565b806305efe9c7146100825780635b207bdf146102c7578063657425551461031f575b600080fd5b6100ce6004803603604081101561009857600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506108b2565b604051808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018060200180602001806020018681526020018060200185810385528a818151815260200191508051906020019080838360005b83811015610152578082015181840152602081019050610137565b50505050905090810190601f16801561017f5780820380516001836020036101000a031916815260200191505b50858103845289818151815260200191508051906020019080838360005b838110156101b857808201518184015260208101905061019d565b50505050905090810190601f1680156101e55780820380516001836020036101000a031916815260200191505b50858103835288818151815260200191508051906020019080838360005b8381101561021e578082015181840152602081019050610203565b50505050905090810190601f16801561024b5780820380516001836020036101000a031916815260200191505b50858103825286818151815260200191508051906020019080838360005b83811015610284578082015181840152602081019050610269565b50505050905090810190601f1680156102b15780820380516001836020036101000a031916815260200191505b509a505050505050505050505060405180910390f35b610309600480360360208110156102dd57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610b88565b6040518082815260200191505060405180910390f35b61036b6004803603604081101561033557600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610cb2565b604051808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018060200180602001806020018060200186815260200185810385528a818151815260200191508051906020019080838360005b838110156103ef5780820151818401526020810190506103d4565b50505050905090810190601f16801561041c5780820380516001836020036101000a031916815260200191505b50858103845289818151815260200191508051906020019080838360005b8381101561045557808201518184015260208101905061043a565b50505050905090810190601f1680156104825780820380516001836020036101000a031916815260200191505b50858103835288818151815260200191508051906020019080838360005b838110156104bb5780820151818401526020810190506104a0565b50505050905090810190601f1680156104e85780820380516001836020036101000a031916815260200191505b50858103825287818151815260200191508051906020019080838360005b83811015610521578082015181840152602081019050610506565b50505050905090810190601f16801561054e5780820380516001836020036101000a031916815260200191505b509a505050505050505050505060405180910390f35b61056c611186565b6040518082815260200191505060405180910390f35b61058a61118c565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b610618600480360360408110156105e257600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506111b1565b604051808215151515815260200191505060405180910390f35b6108b06004803603608081101561064857600080fd5b810190808035906020019064010000000081111561066557600080fd5b82018360208201111561067757600080fd5b8035906020019184600183028401116401000000008311171561069957600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001906401000000008111156106fc57600080fd5b82018360208201111561070e57600080fd5b8035906020019184600183028401116401000000008311171561073057600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561079357600080fd5b8201836020820111156107a557600080fd5b803590602001918460018302840111640100000000831117156107c757600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561082a57600080fd5b82018360208201111561083c57600080fd5b8035906020019184600183028401116401000000008311171561085e57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050611973565b005b600260205281600052604060002081815481106108cb57fe5b9060005260206000209060060201600091509150508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690806001018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561099e5780601f106109735761010080835404028352916020019161099e565b820191906000526020600020905b81548152906001019060200180831161098157829003601f168201915b505050505090806002018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610a3c5780601f10610a1157610100808354040283529160200191610a3c565b820191906000526020600020905b815481529060010190602001808311610a1f57829003601f168201915b505050505090806003018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610ada5780601f10610aaf57610100808354040283529160200191610ada565b820191906000526020600020905b815481529060010190602001808311610abd57829003601f168201915b505050505090806004015490806005018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610b7e5780601f10610b5357610100808354040283529160200191610b7e565b820191906000526020600020905b815481529060010190602001808311610b6157829003601f168201915b5050505050905086565b600080600090506000600260008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002080549050905060008090505b81811015610ca757600073ffffffffffffffffffffffffffffffffffffffff16600260008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208281548110610c4657fe5b906000526020600020906006020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614610c9a578260010192505b8080600101915050610bdc565b508192505050919050565b60006060806060806000600260008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208781548110610d0657fe5b906000526020600020906006020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600260008a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208881548110610d8257fe5b9060005260206000209060060201600101600260008b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208981548110610ddd57fe5b9060005260206000209060060201600201600260008c73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208a81548110610e3857fe5b9060005260206000209060060201600301600260008d73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208b81548110610e9357fe5b9060005260206000209060060201600501600260008e73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208c81548110610eee57fe5b906000526020600020906006020160040154848054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610f955780601f10610f6a57610100808354040283529160200191610f95565b820191906000526020600020905b815481529060010190602001808311610f7857829003601f168201915b50505050509450838054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156110315780601f1061100657610100808354040283529160200191611031565b820191906000526020600020905b81548152906001019060200180831161101457829003601f168201915b50505050509350828054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156110cd5780601f106110a2576101008083540402835291602001916110cd565b820191906000526020600020905b8154815290600101906020018083116110b057829003601f168201915b50505050509250818054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156111695780601f1061113e57610100808354040283529160200191611169565b820191906000526020600020905b81548152906001019060200180831161114c57829003601f168201915b505050505091509550955095509550955095509295509295509295565b60015481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600080600090505b600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020805490508110156119675782600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020828154811061124e57fe5b906000526020600020906006020160040154141561195a5761126e611bcd565b6040518060c001604052808673ffffffffffffffffffffffffffffffffffffffff168152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002084815481106112df57fe5b90600052602060002090600602016001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156113845780601f1061135957610100808354040283529160200191611384565b820191906000526020600020905b81548152906001019060200180831161136757829003601f168201915b50505050508152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002084815481106113d857fe5b90600052602060002090600602016002018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561147d5780601f106114525761010080835404028352916020019161147d565b820191906000526020600020905b81548152906001019060200180831161146057829003601f168201915b50505050508152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002084815481106114d157fe5b90600052602060002090600602016003018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156115765780601f1061154b57610100808354040283529160200191611576565b820191906000526020600020905b81548152906001019060200180831161155957829003601f168201915b50505050508152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002084815481106115ca57fe5b9060005260206000209060060201600401548152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020848154811061162b57fe5b90600052602060002090600602016005018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156116d05780601f106116a5576101008083540402835291602001916116d0565b820191906000526020600020905b8154815290600101906020018083116116b357829003601f168201915b50505050508152509050600260008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819080600181540180825580915050906001820390600052602060002090600602016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010190805190602001906117a8929190611c19565b5060408201518160020190805190602001906117c5929190611c19565b5060608201518160030190805190602001906117e2929190611c19565b506080820151816004015560a0820151816005019080519060200190611809929190611c19565b50505050600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020828154811061185757fe5b9060005260206000209060060201600080820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff021916905560018201600061189d9190611c99565b6002820160006118ad9190611c99565b6003820160006118bd9190611c99565b60048201600090556005820160006118d59190611c99565b5050600160008154809291906001900391905055508473ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef866040518082815260200191505060405180910390a360019250505061196d565b80806001019150506111b9565b50600090505b92915050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146119cc57600080fd5b60018054016001819055506119df611bcd565b6040518060c001604052803373ffffffffffffffffffffffffffffffffffffffff1681526020018681526020018581526020018381526020016001548152602001848152509050600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819080600181540180825580915050906001820390600052602060002090600602016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506020820151816001019080519060200190611af4929190611c19565b506040820151816002019080519060200190611b11929190611c19565b506060820151816003019080519060200190611b2e929190611c19565b506080820151816004015560a0820151816005019080519060200190611b55929190611c19565b505050507f2728c9d3205d667bbc0eefdfeda366261b4d021949630c047f3e5834b30611ab33600154604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a15050505050565b6040518060c00160405280600073ffffffffffffffffffffffffffffffffffffffff16815260200160608152602001606081526020016060815260200160008152602001606081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10611c5a57805160ff1916838001178555611c88565b82800160010185558215611c88579182015b82811115611c87578251825591602001919060010190611c6c565b5b509050611c959190611ce1565b5090565b50805460018160011615610100020316600290046000825580601f10611cbf5750611cde565b601f016020900490600052602060002090810190611cdd9190611ce1565b5b50565b611d0391905b80821115611cff576000816000905550600101611ce7565b5090565b9056fea265627a7a723158209b364f4ae3327ce4aa75b513a97668f7984070c692dd6f77fb503f3a0c69c59a64736f6c63430005100032";

    public static final String FUNC___OWNEDLANDS = "__ownedLands";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_TOTALLANDSCOUNTER = "totalLandsCounter";

    public static final String FUNC_ADDLAND = "addLand";

    public static final String FUNC_TRANSFERLAND = "transferLand";

    public static final String FUNC_GETLAND = "getLand";

    public static final String FUNC_GETNOOFLAND = "getNoOfLand";

    public static final Event ADD_EVENT = new Event("Add", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
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

    public RemoteCall<Tuple6<String, String, String, String, BigInteger, String>> __ownedLands(String param0, BigInteger param1) {
        final Function function = new Function(FUNC___OWNEDLANDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple6<String, String, String, String, BigInteger, String>>(
                new Callable<Tuple6<String, String, String, String, BigInteger, String>>() {
                    @Override
                    public Tuple6<String, String, String, String, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<String, String, String, String, BigInteger, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (String) results.get(5).getValue());
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

    public RemoteCall<TransactionReceipt> addLand(String _district, String _street, String _pathImage, String _cost) {
        final Function function = new Function(
                FUNC_ADDLAND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_district), 
                new org.web3j.abi.datatypes.Utf8String(_street), 
                new org.web3j.abi.datatypes.Utf8String(_pathImage), 
                new org.web3j.abi.datatypes.Utf8String(_cost)), 
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

    public RemoteCall<Tuple6<String, String, String, String, String, BigInteger>> getLand(String _landHolder, BigInteger _index) {
        final Function function = new Function(FUNC_GETLAND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_landHolder), 
                new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple6<String, String, String, String, String, BigInteger>>(
                new Callable<Tuple6<String, String, String, String, String, BigInteger>>() {
                    @Override
                    public Tuple6<String, String, String, String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<String, String, String, String, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue());
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

    public static class TransferEventResponse {
        public Log log;

        public String _from;

        public String _to;

        public BigInteger _landId;
    }
}

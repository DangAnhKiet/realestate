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
import org.web3j.tuples.generated.Tuple7;
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
    private static final String BINARY = "0x608060405234801561001057600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600181905550611f71806100686000396000f3fe608060405234801561001057600080fd5b506004361061007d5760003560e01c80635f62853f1161005b5780635f62853f1461058e57806382f557ae1461081b5780638da5cb5b14610839578063b3f40d6a146108835761007d565b806305efe9c7146100825780634e995f6e146102dc5780635b207bdf14610536575b600080fd5b6100ce6004803603604081101561009857600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506108e9565b604051808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018060200180602001806020018781526020018060200186600281111561012657fe5b60ff16815260200185810385528b818151815260200191508051906020019080838360005b8381101561016657808201518184015260208101905061014b565b50505050905090810190601f1680156101935780820380516001836020036101000a031916815260200191505b5085810384528a818151815260200191508051906020019080838360005b838110156101cc5780820151818401526020810190506101b1565b50505050905090810190601f1680156101f95780820380516001836020036101000a031916815260200191505b50858103835289818151815260200191508051906020019080838360005b83811015610232578082015181840152602081019050610217565b50505050905090810190601f16801561025f5780820380516001836020036101000a031916815260200191505b50858103825287818151815260200191508051906020019080838360005b8381101561029857808201518184015260208101905061027d565b50505050905090810190601f1680156102c55780820380516001836020036101000a031916815260200191505b509b50505050505050505050505060405180910390f35b610328600480360360408110156102f257600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610bd2565b604051808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018060200180602001806020018060200187600281111561037a57fe5b60ff16815260200186815260200185810385528b818151815260200191508051906020019080838360005b838110156103c05780820151818401526020810190506103a5565b50505050905090810190601f1680156103ed5780820380516001836020036101000a031916815260200191505b5085810384528a818151815260200191508051906020019080838360005b8381101561042657808201518184015260208101905061040b565b50505050905090810190601f1680156104535780820380516001836020036101000a031916815260200191505b50858103835289818151815260200191508051906020019080838360005b8381101561048c578082015181840152602081019050610471565b50505050905090810190601f1680156104b95780820380516001836020036101000a031916815260200191505b50858103825288818151815260200191508051906020019080838360005b838110156104f25780820151818401526020810190506104d7565b50505050905090810190601f16801561051f5780820380516001836020036101000a031916815260200191505b509b50505050505050505050505060405180910390f35b6105786004803603602081101561054c57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061118f565b6040518082815260200191505060405180910390f35b610819600480360360a08110156105a457600080fd5b81019080803590602001906401000000008111156105c157600080fd5b8201836020820111156105d357600080fd5b803590602001918460018302840111640100000000831117156105f557600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561065857600080fd5b82018360208201111561066a57600080fd5b8035906020019184600183028401116401000000008311171561068c57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001906401000000008111156106ef57600080fd5b82018360208201111561070157600080fd5b8035906020019184600183028401116401000000008311171561072357600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561078657600080fd5b82018360208201111561079857600080fd5b803590602001918460018302840111640100000000831117156107ba57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803560ff1690602001909291905050506112b9565b005b61082361154e565b6040518082815260200191505060405180910390f35b610841611554565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6108cf6004803603604081101561089957600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050611579565b604051808215151515815260200191505060405180910390f35b6002602052816000526040600020818154811061090257fe5b9060005260206000209060070201600091509150508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690806001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156109d55780601f106109aa576101008083540402835291602001916109d5565b820191906000526020600020905b8154815290600101906020018083116109b857829003601f168201915b505050505090806002018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610a735780601f10610a4857610100808354040283529160200191610a73565b820191906000526020600020905b815481529060010190602001808311610a5657829003601f168201915b505050505090806003018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610b115780601f10610ae657610100808354040283529160200191610b11565b820191906000526020600020905b815481529060010190602001808311610af457829003601f168201915b505050505090806004015490806005018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610bb55780601f10610b8a57610100808354040283529160200191610bb5565b820191906000526020600020905b815481529060010190602001808311610b9857829003601f168201915b5050505050908060060160009054906101000a900460ff16905087565b6000606080606080600080610be5611df1565b6040518060e00160405280600260008d73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208b81548110610c3a57fe5b906000526020600020906007020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001600260008d73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208b81548110610cd157fe5b90600052602060002090600702016001018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610d765780601f10610d4b57610100808354040283529160200191610d76565b820191906000526020600020905b815481529060010190602001808311610d5957829003601f168201915b50505050508152602001600260008d73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208b81548110610dca57fe5b90600052602060002090600702016002018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610e6f5780601f10610e4457610100808354040283529160200191610e6f565b820191906000526020600020905b815481529060010190602001808311610e5257829003601f168201915b50505050508152602001600260008d73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208b81548110610ec357fe5b90600052602060002090600702016003018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610f685780601f10610f3d57610100808354040283529160200191610f68565b820191906000526020600020905b815481529060010190602001808311610f4b57829003601f168201915b50505050508152602001600260008d73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208b81548110610fbc57fe5b9060005260206000209060070201600401548152602001600260008d73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208b8154811061101d57fe5b90600052602060002090600702016005018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156110c25780601f10611097576101008083540402835291602001916110c2565b820191906000526020600020905b8154815290600101906020018083116110a557829003601f168201915b50505050508152602001600260008d73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208b8154811061111657fe5b906000526020600020906007020160060160009054906101000a900460ff16600281111561114057fe5b815250905080600001518160200151826040015183606001518460a001518560c00151866080015185955084945083935082925097509750975097509750975097505092959891949750929550565b600080600090506000600260008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002080549050905060008090505b818110156112ae57600073ffffffffffffffffffffffffffffffffffffffff16600260008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020828154811061124d57fe5b906000526020600020906007020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16146112a1578260010192505b80806001019150506111e3565b508192505050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461131257600080fd5b6001805401600181905550611325611df1565b6040518060e001604052803373ffffffffffffffffffffffffffffffffffffffff168152602001878152602001868152602001848152602001600154815260200185815260200183600281111561137857fe5b8152509050600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819080600181540180825580915050906001820390600052602060002090600702016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550602082015181600101908051906020019061144b929190611e4f565b506040820151816002019080519060200190611468929190611e4f565b506060820151816003019080519060200190611485929190611e4f565b506080820151816004015560a08201518160050190805190602001906114ac929190611e4f565b5060c08201518160060160006101000a81548160ff021916908360028111156114d157fe5b02179055505050507f2728c9d3205d667bbc0eefdfeda366261b4d021949630c047f3e5834b30611ab33600154604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a1505050505050565b60015481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600080600090505b600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002080549050811015611de55782600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020828154811061161657fe5b9060005260206000209060070201600401541415611dd857611636611df1565b6040518060e001604052808673ffffffffffffffffffffffffffffffffffffffff168152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002084815481106116a757fe5b90600052602060002090600702016001018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561174c5780601f106117215761010080835404028352916020019161174c565b820191906000526020600020905b81548152906001019060200180831161172f57829003601f168201915b50505050508152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002084815481106117a057fe5b90600052602060002090600702016002018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156118455780601f1061181a57610100808354040283529160200191611845565b820191906000526020600020905b81548152906001019060200180831161182857829003601f168201915b50505050508152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020848154811061189957fe5b90600052602060002090600702016003018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561193e5780601f106119135761010080835404028352916020019161193e565b820191906000526020600020905b81548152906001019060200180831161192157829003601f168201915b50505050508152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020848154811061199257fe5b9060005260206000209060070201600401548152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002084815481106119f357fe5b90600052602060002090600702016005018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611a985780601f10611a6d57610100808354040283529160200191611a98565b820191906000526020600020905b815481529060010190602001808311611a7b57829003601f168201915b50505050508152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208481548110611aec57fe5b906000526020600020906007020160060160009054906101000a900460ff166002811115611b1657fe5b8152509050600260008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819080600181540180825580915050906001820390600052602060002090600702016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506020820151816001019080519060200190611be9929190611e4f565b506040820151816002019080519060200190611c06929190611e4f565b506060820151816003019080519060200190611c23929190611e4f565b506080820151816004015560a0820151816005019080519060200190611c4a929190611e4f565b5060c08201518160060160006101000a81548160ff02191690836002811115611c6f57fe5b0217905550505050600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208281548110611cc157fe5b9060005260206000209060070201600080820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff0219169055600182016000611d079190611ecf565b600282016000611d179190611ecf565b600382016000611d279190611ecf565b6004820160009055600582016000611d3f9190611ecf565b6006820160006101000a81549060ff02191690555050600160008154809291906001900391905055508473ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef866040518082815260200191505060405180910390a3600192505050611deb565b8080600101915050611581565b50600090505b92915050565b6040518060e00160405280600073ffffffffffffffffffffffffffffffffffffffff168152602001606081526020016060815260200160608152602001600081526020016060815260200160006002811115611e4957fe5b81525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10611e9057805160ff1916838001178555611ebe565b82800160010185558215611ebe579182015b82811115611ebd578251825591602001919060010190611ea2565b5b509050611ecb9190611f17565b5090565b50805460018160011615610100020316600290046000825580601f10611ef55750611f14565b601f016020900490600052602060002090810190611f139190611f17565b5b50565b611f3991905b80821115611f35576000816000905550600101611f1d565b5090565b9056fea265627a7a7231582072e29a0b9345ea505aff4e97ed41821c70b59439b96b113ec56cc6674f28571c64736f6c63430005100032";

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

    public RemoteCall<Tuple7<String, String, String, String, BigInteger, String, BigInteger>> __ownedLands(String param0, BigInteger param1) {
        final Function function = new Function(FUNC___OWNEDLANDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}));
        return new RemoteCall<Tuple7<String, String, String, String, BigInteger, String, BigInteger>>(
                new Callable<Tuple7<String, String, String, String, BigInteger, String, BigInteger>>() {
                    @Override
                    public Tuple7<String, String, String, String, BigInteger, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<String, String, String, String, BigInteger, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue());
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

    public RemoteCall<TransactionReceipt> addLand(String _district, String _street, String _pathImage, String _cost, BigInteger _status) {
        final Function function = new Function(
                FUNC_ADDLAND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_district), 
                new org.web3j.abi.datatypes.Utf8String(_street), 
                new org.web3j.abi.datatypes.Utf8String(_pathImage), 
                new org.web3j.abi.datatypes.Utf8String(_cost), 
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

    public RemoteCall<Tuple7<String, String, String, String, String, BigInteger, BigInteger>> getLandByAddress(String _landHolder, BigInteger _index) {
        final Function function = new Function(FUNC_GETLANDBYADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_landHolder), 
                new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple7<String, String, String, String, String, BigInteger, BigInteger>>(
                new Callable<Tuple7<String, String, String, String, String, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple7<String, String, String, String, String, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<String, String, String, String, String, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue());
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

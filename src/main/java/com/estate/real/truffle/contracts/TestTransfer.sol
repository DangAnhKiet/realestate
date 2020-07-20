pragma solidity ^0.5.0;

contract ContractSend{

    address owner;
    constructor() public{
        owner = msg.sender;
    }

    function getAddress() public view returns(address){
        return address(this);
    }

    function getEth() public returns(uint){
        return owner.balance;
    }

    function sendEth(address payable _recieve) payable external {
        uint amount = msg.value;
        _recieve.transfer(amount);
    }
}

contract ContractReceive{
    function () external payable{}

    function getAddress() public view returns(address){
        return address(this);
    }

    function getEthReceive() public view returns(uint){
        return address(this).balance;
    }

    function getEthOfSender() public returns(uint){
        return msg.sender.balance;
    }
}
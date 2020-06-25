pragma solidity ^0.5.0;

contract ManageRealEsate {
    struct Land
    {
        address ownerAddress;
        string district;
        string street;
        uint cost;
        uint landID;
    }

    address public owner;   // government who creates the contract
    uint public totalLandsCounter; //total no of lands via this contract at any time
    //    string public forTest;
    constructor() public {
        owner = msg.sender;
        totalLandsCounter = 0;
        //        forTest = "Thanh cong";
    }
    event Add(address _owner, uint _landID);
    event Transfer(address indexed _from, address indexed _to, uint _landId);
    modifier isOwner
    {
        require(msg.sender == owner);
        _;
    }
    mapping(address => Land[]) public __ownedLands;
    //1. FIRST OPERATION
    //Nhân viên sở tài nguyên sẽ thêm bds bằng hàm này
    function addLand(string memory _district, string memory _street, uint _cost) public isOwner
    {
        totalLandsCounter = totalLandsCounter + 1;
        Land memory myLand = Land(
            {
            ownerAddress : msg.sender,
            district : _district,
            street : _street,
            cost : _cost,
            landID : totalLandsCounter
            });
        __ownedLands[msg.sender].push(myLand);
        emit Add(msg.sender, totalLandsCounter);
    }
    //2. SECOND OPERATION
    //caller (owner/anyone) to transfer land to buyer provided caller is owner of the land
    function transferLand(address _landBuyer, uint _landID) public returns (bool)
    {
        //find out the particular land ID in owner's collection
        for(uint i=0; i < (__ownedLands[msg.sender].length);i++)
        {
            //if given land ID is indeed in owner's collection
            if (__ownedLands[msg.sender][i].landID == _landID)
            {
                //copy land in new owner's collection
                Land memory myLand = Land(
                    {
                    ownerAddress : _landBuyer,
                    district : __ownedLands[msg.sender][i].district,
                    street : __ownedLands[msg.sender][i].street,
                    cost : __ownedLands[msg.sender][i].cost,
                    landID : __ownedLands[msg.sender][i].landID
                    });
                __ownedLands[_landBuyer].push(myLand);

                //remove land from current ownerAddress
                delete __ownedLands[msg.sender][i];
                totalLandsCounter--;

                //inform the world
                emit Transfer(msg.sender, _landBuyer, _landID);

                return true;
            }
        }

        //if we still did not return, return false
        return false;
    }
    //3. GET A LAND OF AN ACCOUNT
    function getLand(address _landHolder, uint _index) public view returns (address, string memory, string memory, uint, uint){
        return (__ownedLands[_landHolder][_index].ownerAddress,
        __ownedLands[_landHolder][_index].district,
        __ownedLands[_landHolder][_index].street,
        __ownedLands[_landHolder][_index].cost,
        __ownedLands[_landHolder][_index].landID);
    }

    //4. GET TOTAL NO OF LANDS
    function getNoOfLand(address _landHolder) external view returns(uint){
        uint size = 0;
        uint lengthOfArr= __ownedLands[_landHolder].length;
        for(uint i =0;i<lengthOfArr;i++){
            if(__ownedLands[_landHolder][i].ownerAddress != address(0)){
                ++size;
            }
        }
        return size;
    }
}
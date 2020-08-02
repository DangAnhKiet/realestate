pragma solidity ^0.5.0;

contract ManageRealEsate {
    enum Status {active, pending, deleted}
    function () external payable{}
    struct Land
    {
        address ownerAddress;
        string district;
        string street;
        string ward;
        string cost;
        string description;
        uint landID;
        string pathImage;
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
    event Pay(address indexed _from, uint _value, uint _landId);
    modifier isOwner
    {
        require(msg.sender == owner);
        _;
    }
    modifier costs(uint _price){
        require(msg.value >= _price);
        _;
    }
    mapping(address => Land[]) public __ownedLands;
    //1. FIRST OPERATION
    //Nhân viên sở tài nguyên sẽ thêm bds bằng hàm này
    function addLand(string memory _district, string memory _street, string memory _pathImage, string memory _cost, string memory _ward,
        string memory _description)
    public isOwner
    {
        totalLandsCounter = totalLandsCounter + 1;
        Land memory myLand = Land(
            {
            ownerAddress : msg.sender,
            district : _district,
            street : _street,
            cost : _cost,
            ward : _ward,
            description : _description,
            pathImage : _pathImage,
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
        // PAYABLE
        for (uint i = 0; i < (__ownedLands[msg.sender].length); i++)
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
                    ward : __ownedLands[msg.sender][i].ward,
                    description : __ownedLands[msg.sender][i].description,
                    pathImage : __ownedLands[msg.sender][i].pathImage,
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
    function getLandByAddress(address _landHolder, uint _index) public view returns (address, string memory, string
        memory,
        string memory,string memory, string memory, string memory, uint){
        Land memory land = Land(
            {
            ownerAddress : __ownedLands[_landHolder][_index].ownerAddress,
            district : __ownedLands[_landHolder][_index].district,
            street : __ownedLands[_landHolder][_index].street,
            cost : __ownedLands[_landHolder][_index].cost,
            ward : __ownedLands[_landHolder][_index].ward,
            description : __ownedLands[_landHolder][_index].description,
            pathImage : __ownedLands[_landHolder][_index].pathImage,
            landID : __ownedLands[_landHolder][_index].landID
            });
        return (land.ownerAddress,
        land.district,
        land.street,
        land.cost,
        land.ward,
        land.description,
        land.pathImage,
        land.landID);
    }
    //4. GET ALL LAND FOR ADMIN
//    function getAllLands() public view returns(address, string memory, string memory, string memory, string memory,
//        Status, uint){
//
//    }
    //5. GET TOTAL NO OF LANDS
    function getNoOfLand(address _landHolder) external view returns (uint){
        uint size = 0;
        uint lengthOfArr = __ownedLands[_landHolder].length;
        for (uint i = 0; i < lengthOfArr; i++) {
            if (__ownedLands[_landHolder][i].ownerAddress != address(0)) {
                ++size;
            }
        }
        return size;
    }
}
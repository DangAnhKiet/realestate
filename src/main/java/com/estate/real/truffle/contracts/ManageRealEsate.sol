pragma solidity ^0.5.0;

contract ManageRealEsate {
    enum Status {active, pending, deleted}
    function() external payable {}

    struct History {
        address addressBuyer;
        address addressSeller;
        string cost;
        string date;
        string image;
    }

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
    event Transfer(address _from, address _to, uint _landId);
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
    mapping(uint => History[]) public __historyList;
    //1. FIRST OPERATION
    //Nhân viên sở tài nguyên sẽ thêm bds bằng hàm này
    function addLand(address _ownerLand, string memory _district, string memory _street, string memory _pathImage, string memory _cost, string
        memory
        _ward,
        string memory _description)
    public isOwner
    {
        totalLandsCounter = totalLandsCounter + 1;
        Land memory myLand = Land(
            {
            ownerAddress : _ownerLand,
            district : _district,
            street : _street,
            cost : _cost,
            ward : _ward,
            description : _description,
            pathImage : _pathImage,
            landID : totalLandsCounter
            });
        __ownedLands[_ownerLand].push(myLand);
        emit Add(_ownerLand, totalLandsCounter);
    }
    //2. SECOND OPERATION
    //caller (owner/anyone) to transfer land to buyer provided caller is owner of the land
    function transferLand(address _landBuyer, address _ownerLand, uint _landID, string memory _date, string memory _image) public returns (bool)
    {
        //find out the particular land ID in owner's collection
        // PAYABLE
        for (uint i = 0; i < (__ownedLands[_ownerLand].length); i++)
        {
            //if given land ID is indeed in owner's collection
            if (__ownedLands[_ownerLand][i].landID == _landID)
            {
                //copy land in new owner's collection
                Land memory myLand = Land(
                    {
                    ownerAddress : _landBuyer,
                    district : __ownedLands[_ownerLand][i].district,
                    street : __ownedLands[_ownerLand][i].street,
                    cost : __ownedLands[_ownerLand][i].cost,
                    ward : __ownedLands[_ownerLand][i].ward,
                    description : __ownedLands[_ownerLand][i].description,
                    pathImage : __ownedLands[_ownerLand][i].pathImage,
                    landID : __ownedLands[_ownerLand][i].landID
                    });
                __ownedLands[_landBuyer].push(myLand);

                //remove land from current ownerAddress
                delete __ownedLands[_ownerLand][i];
                totalLandsCounter--;

                //Save __historyList
                History memory historyTemp = History({
                    addressBuyer : _landBuyer,
                    addressSeller : _ownerLand,
                    cost : __ownedLands[_landBuyer][i].cost,
                    date : _date,
                    image : _image
                    });
                __historyList[_landID].push(historyTemp);
                //inform the world
                emit Transfer(_ownerLand, _landBuyer, _landID);
                return true;
            }
        }

        //if we still did not return, return false
        return false;
    }
    //3.1 GET A HISTORY OF AN LAND
    function getHistoryByLandId(uint _landId, uint _index) public view returns (address, address, string
        memory, string memory, string memory){
        History memory historyTemp = History(
        {
        addressBuyer : __historyList[_landId][_index].addressBuyer,
        addressSeller : __historyList[_landId][_index].addressSeller,
        cost : __historyList[_landId][_index].cost,
        date : __historyList[_landId][_index].date,
        image : __historyList[_landId][_index].image
        });
        return (
        historyTemp.addressBuyer,
        historyTemp.addressSeller,
        historyTemp.cost,
        historyTemp.date,
        historyTemp.image
      );
    }
    //3. GET A LAND OF AN ACCOUNT
    function getLandByAddress(address _landHolder, uint _index) public view returns (address, string memory, string
        memory,
        string memory, string memory, string memory, string memory, uint){
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
    //5.1 GET TOTAL NO OF HISTORY
    function getNoOfHistory(uint _landId) external view returns (uint){
        uint size = 0;
        uint lengthOfArr = __historyList[_landId].length;
        for (uint i = 0; i < lengthOfArr; i++) {
            if (__historyList[_landId][i].addressBuyer != address(0) && (__historyList[_landId][i].addressSeller != address(0))) {
                ++size;
            }
        }
        return size;
    }
}
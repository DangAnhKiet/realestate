// const Migrations = artifacts.require("Migrations");
// const ManageRealEsate = artifacts.require("ManageRealEsate");
const TestTransfer = artifacts.require("TestTransfer");

module.exports = function(deployer) {
  deployer.deploy(TestTransfer);
};

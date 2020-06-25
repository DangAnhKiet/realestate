// const Migrations = artifacts.require("Migrations");
const ManageRealEsate = artifacts.require("ManageRealEsate");

module.exports = function(deployer) {
  deployer.deploy(ManageRealEsate);
};

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageProduct;

public class ManageProductTestCases extends BaseClass{
 
	LoginPage lp;
	HomePage hp;
	ManageProduct mp;
	
	@Test(enabled= false)
  public void verifyManageProductTitle() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		mp =new ManageProduct(driver);
		lp.performLogin(Constants.userName, Constants.password);
		mp.loadManageProductPage();
		Assert.assertEquals(mp.getManagePdtPageTitle(), Constants.ManagePdtPageTitle, "::Page Title is not as expected");
		
  }
	
	@Test(enabled=false)
	  public void verifyManageProductPageisLoaded() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		mp =new ManageProduct(driver);
		lp.performLogin(Constants.userName, Constants.password);
		mp.loadManageProductPage();
		Assert.assertEquals(mp.getManageProductPageText(), Constants.ManagePdtPageHeader, ":: Page is not loaded");
	  }
	
	@Test(enabled=true)
	  public void verifyAddNewProductPageDefaultValues() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		mp =new ManageProduct(driver);
		lp.performLogin(Constants.userName, Constants.password);
		mp.loadManageProductPage();
		mp.loadAddNewPdtPage();
		Assert.assertTrue(mp.unLimitedStockCheckboxStatus(), "Failed, Checkbox is not checked by default");
		Assert.assertTrue(mp.ProductTypeDefaultValue(), ":: Failed, Radio button  Veg not selected by default");
		Assert.assertTrue(mp.PriceTypeDefaultValue(), ":: Failed, Radio button Weight not selected by default");
	  }
	
}

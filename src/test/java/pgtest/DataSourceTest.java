package pgtest;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.JsonObject;
import com.pgtest.config.RootConfig;
import com.pgtest.dto.MerchandiseDTO;
import com.pgtest.dto.OrderDTO;
import com.pgtest.dto.OrderValidator;
import com.pgtest.dto.OrdererDTO;
import com.pgtest.dto.PaidResultDTO;
import com.pgtest.service.MerchandiseService;
import com.pgtest.service.OrdererService;
import com.pgtest.service.PayService;
import com.pgtest.util.UsingImPortAPI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class DataSourceTest {
	private static Logger logger = Logger.getLogger(DataSourceTest.class);
	
	@Autowired
	private OrdererService service;
	@Autowired
	private MerchandiseService mService;
	@Autowired
	private PayService pService;
	
	@Test
	public void test() {

		
	}
}

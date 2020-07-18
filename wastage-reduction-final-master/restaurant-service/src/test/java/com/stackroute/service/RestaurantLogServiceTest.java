//package com.stackroute.restaurant.restaurantlogserver.service;
//import RestaurantLogs;
//import com.stackroute.restaurant.restaurantlogserver.exceptions.RestaurantIdAlreadyExistsException;
//import RestaurantLogRepository;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//public class RestaurantLogServiceTest {
//    private RestaurantLogs restaurantLogs;
//
//    //Create a mock for UserRepository
//    @Mock
//    private RestaurantLogRepository restaurantLogRepository;
//
//    //Inject the mocks as dependencies into UserServiceImpl
//    @InjectMocks
//    private RestaurantLogServiceImpl restaurantLogServiceImpl;
//    List<RestaurantLogs> list= null;
//
//
//    @Before
//    public void setUp() throws Exception {
//
//        MockitoAnnotations.initMocks(this);
//        restaurantLogs = new RestaurantLogs();
//        restaurantLogs.setRestaurantlogid(7);
//        restaurantLogs.setFoodavailable(90);
//        restaurantLogs.setRating("5stsr");
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
//        String dateInString = "2019-02-03 10:08:02";
//        Date date = formatter.parse(dateInString);
//        restaurantLogs.setLastUpdate(date);
//        restaurantLogs.setStatus("yes");
//        list = new ArrayList();
//        list.add(restaurantLogs);
//
//    }
//
//
//
//
//    @Test
//    public void saveRestaurantLog() throws RestaurantIdAlreadyExistsException {
//        when(restaurantLogRepository.save((RestaurantLogs) any())).thenReturn(restaurantLogs);
//        RestaurantLogs savedrestaurantLog = restaurantLogServiceImpl.saveRestaurantLog(restaurantLogs);
//        Assert.assertEquals(restaurantLogs,savedrestaurantLog);
//        System.out.println(savedrestaurantLog);
//        //verify here verifies that userRepository save method is only called once
//        verify(restaurantLogRepository,times(1)).save(restaurantLogs);
//    }
//
//
//
//    @Test(expected = RestaurantIdAlreadyExistsException.class)
//    public void saveRestaurantLogTestFailure() throws RestaurantIdAlreadyExistsException {
//        when(restaurantLogRepository.save((RestaurantLogs) any())).thenReturn(null);
//        RestaurantLogs savedRestaurantLog = restaurantLogServiceImpl.saveRestaurantLog(restaurantLogs);
//        System.out.println("savedres"+savedRestaurantLog);
//        Assert.assertEquals(restaurantLogs,savedRestaurantLog);
//    }
//
//
//    @Test
//    public void getAllRestaurantLog() throws Exception {
//        restaurantLogRepository.save(restaurantLogs);
//        //stubbing the mock to return specific data
//        when(restaurantLogRepository.findAll()).thenReturn(list);
//        List<RestaurantLogs> userlist = restaurantLogServiceImpl.getAllRestaurantLog();
//
//        Assert.assertEquals(list,userlist);
//    }
//}
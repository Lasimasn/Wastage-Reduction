package com.stackroute.seedData;


import com.stackroute.controller.DonationController;
import com.stackroute.domain.Restaurant;
import com.stackroute.domain.RestaurantActivity;
import com.stackroute.service.DonationService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileInputStream;
import java.text.NumberFormat;
import java.util.Locale;

@Component
public class FoodAvailabilityData {

    @Autowired
    DonationController donationController;

    @Autowired
    DonationService donationService;

    public String onDataReceived(String username) {
        String foodAvailability = "0";
        try {

            FileInputStream file = new FileInputStream(new File("./foodavailabilityseed.xlsx"));

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheetAt(0);

            System.out.println("");


            for (int i = 1; i < sheet.getLastRowNum()+1; i++) {
                int j = 0;
                NumberFormat fmt = NumberFormat.getInstance(Locale.US);
                if(workbook.getSheetAt(0).getRow(i).getCell(j).toString().equals(username)) {
                    foodAvailability = (Integer.toString((int) Double.parseDouble(workbook.getSheetAt(0).getRow(i).getCell(j + 1).toString())));
                    System.out.println(username + " Food Availability ==> " + foodAvailability);
//                    System.out.println(donationService.updateRestaurantFoodAvailability("muthasi", "70"));
                }
            }

            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return foodAvailability;
    }
}

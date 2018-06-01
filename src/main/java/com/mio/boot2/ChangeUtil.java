package com.mio.boot2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mio.boot2.dto.Agency;
import com.mio.boot2.dto.Agency2;
import com.mio.boot2.dto.Cities;
import com.mio.boot2.dto.District;
import com.mio.boot2.dto.Location;
import com.mio.boot2.dto.Location2;

public class ChangeUtil {
	
	public static String[] locationHead ={"ID","NAME","AREA/CITY","TYPE","ADDRESS","DIRECTION","LAT","LNG"
			,"FAX","TELEPHONE","TELEPHONE DESCRIPTION","OFFICIAL WEBSITE","OPERATION HOURS"};
	public static void main(String[] args) throws Exception {
		
		String path = ChangeUtil.class.getResource("/json/").getPath();
		
		//pca-en-office
//		List<Location> pcaEnOffice = ChangeUtil.readoffice(path+"pca-en-office.json");
	
		//kh-en-offices
//		List<Location> khEnOffice = ChangeUtil.readoffice(path+"kh-en-offices.json");
		
		//ph-en-offices
//		List<Location> phEnOffice = ChangeUtil.readoffice(path+"ph-en-offices.json");
		
		//ph-en-agency
//		List<Agency> phEnAgency = ChangeUtil.readagency(path+"ph-en-agency.json");
		
		//la-lo-locations
//		List<Location2> laLoOffice = ChangeUtil.readoffice2(path+"la-lo-locations.json");
		
		//th-th-locations
//		List<Location> thThOffice = ChangeUtil.readoffice(path+"th-th-locations.json");
		
		//vn-vi-offices
//		List<Location> vnViOffice = ChangeUtil.readoffice(path+"vn-vi-offices.json");
		
		//vn-vi-agency 
//		List<Agency2> vnViAgency = ChangeUtil.readagency2(path+"vn-vi-agency.json");
		
		//vn-en-offices 
//		List<Location> vnEnOffice = ChangeUtil.readoffice(path+"vn-en-offices.json");
		
		//vn-en-agency 
//		List<Agency2> vnEnAgency = ChangeUtil.readagency2(path+"vn-en-agency.json");
		
		//my-en-offices
//		List<Location> myEnOffice = ChangeUtil.readoffice(path+"my-en-offices.json");
		
		//my-en-agency
//		List<Agency> myEnAgency = ChangeUtil.readagency(path+"my-en-agency.json");
		
		//my-my-offices
//		List<Location> myMyOffice = ChangeUtil.readoffice(path+"my-my-offices.json");
		
		//my-my-agency
		List<Agency> myMyAgency = ChangeUtil.readagency(path+"my-my-agency.json");
		
		//sg-en-offices
//		List<Location> sgEnOffice = ChangeUtil.readoffice(path+"sg-en-offices.json");
		
		//id-id-office 
//		List<Location> idIdOffice = ChangeUtil.readoffice(path+"id-id-office.json");
		
		//id-id-agency 
		List<Agency> idIdAgency = ChangeUtil.readagency(path+"id-id-agency.json");
	}
	
	
	public static List<Location> readoffice(String path) throws JsonParseException, JsonMappingException, IOException{
		 
		 ObjectMapper mapper = new ObjectMapper(); 
		 File file = new File(path);

		 List<Location> locations = mapper.readValue(file,  new TypeReference<List<Location>>() { }); 
		
		 System.out.println("read file ["+path+"] success size:"+locations.size());
		  return locations;
	
	}
	
	public static List<Location2> readoffice2(String path) throws Exception{
		 
		 ObjectMapper mapper = new ObjectMapper(); 
		 File file = new File(path);

		 List<Location2> locations = mapper.readValue(file,  new TypeReference<List<Location2>>() { }); 
		
		 System.out.println("read file ["+path+"] success size:"+locations.size());
		  return locations;
	
	}
	
	public static  List<Agency>  readagency(String path) throws Exception{
		Set<String> cities = new HashSet<String>();
		Set<String> states = new HashSet<String>();
		 ObjectMapper mapper = new ObjectMapper(); 
		 File file = new File(path);

		 List<Agency> agencys = mapper.readValue(file,  new TypeReference<List<Agency>>() { }); 
		 for (Agency agency : agencys) {
			
			 if(!StringUtils.isEmpty(agency.getState())){
				 states.add(agency.getState());
			 }else if(!StringUtils.isEmpty(agency.getProvince())){
				 states.add(agency.getProvince());
			 }
			 List<Cities> cs = agency.getCities();
			 for (Cities city : cs) {
				 cities.add(city.getCity());
			}
		}
		 System.out.println("read file ["+path+"] success size:"+agencys.size() +"state size:"+states.size()+"cities size:"+ cities.size());
		 return agencys;
	}
	
	public static  List<Agency2>  readagency2(String path) throws Exception{
		Set<String> cities = new HashSet<String>();
		Set<String> states = new HashSet<String>();
		 ObjectMapper mapper = new ObjectMapper(); 
		 File file = new File(path);

		 List<Agency2> agencys = mapper.readValue(file,  new TypeReference<List<Agency2>>() { }); 
		 for (Agency2 agency : agencys) {
			 states.add(agency.getProvince());
			 List<District> cs = agency.getDistricts();
			 for (District city : cs) {
				 cities.add(city.getDistrict());
			}
		}
		 System.out.println("read file ["+path+"] success size:"+agencys.size() +"state size:"+states.size()+"cities size:"+ cities.size());
		 return agencys;
	}
	

	
	public static void changeLocationToCsv(List<Location> dataList,
			String outPutPath, String filename) {
		File csvFile = null;
		BufferedWriter csvWtriter = null;
		try {
			csvFile = new File(outPutPath + File.separator + filename + ".csv");
			File parent = csvFile.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
			csvFile.createNewFile();

			csvWtriter = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(csvFile), "UTF-8"), 1024);
			// 写入文件头部
			writeRow(locationHead, csvWtriter);
//			public static String[] locationHead ={"ID","NAME","AREA/CITY","TYPE","ADDRESS","DIRECTION","LAT","LNG"
//					,"FAX","TELEPHONE","TELEPHONE DESCRIPTION","OFFICIAL WEBSITE","OPERATION HOURS"};
			// 写入文件内容
			boolean isfirst = true;
			for (Location row : dataList) {
				List<Object> datas = new ArrayList<Object>();
				datas.add(row.getId());
				datas.add(row.getName());
				datas.add("");
				if(isfirst){
					datas.add("headquarter");
				}else{
					datas.add("office");
				}
				datas.add(row.getAddress());
				datas.add(row.getAddress());
				datas.add(row.getLatitude());
				datas.add(row.getLongtitude());
				datas.add(row.getFax());
				//datas.add(row.get);//TELEPHONE
				datas.add(row.getPhoneDescription());//OPERATION HOURS
				datas.add("");//OFFICIAL WEBSITE
				datas.add(row.getOfficeHours());//OPERATION HOURS
//				writeRow(row, csvWtriter);
			}
			csvWtriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				csvWtriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	 /**
     * CSV文件生成方法
     * @param head
     * @param dataList
     * @param outPutPath
     * @param filename
     * @return
     */
    public static File createCSVFile(List<Object> head, List<List<Object>> dataList,
            String outPutPath, String filename) {

        File csvFile = null;
        BufferedWriter csvWtriter = null;
        try {
            csvFile = new File(outPutPath + File.separator + filename + ".csv");
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            csvFile.createNewFile();

            csvWtriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                    csvFile), "UTF-8"), 1024);
            // 写入文件头部
//            writeRow(head, csvWtriter);

            // 写入文件内容
            for (List<Object> row : dataList) {
//                writeRow(row, csvWtriter);
            }
            csvWtriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvWtriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvFile;
    }

    /**
     * 写一行数据方法
     * @param row
     * @param csvWriter
     * @throws IOException
     */
    private static void writeRow(String[] row, BufferedWriter csvWriter) throws IOException {
        // 写入文件头部
        for (String data : row) {
            StringBuffer sb = new StringBuffer();
            String rowStr = sb.append("\"").append(data).append("\",").toString();
            csvWriter.write(rowStr);
        }
        csvWriter.newLine();
    }
}

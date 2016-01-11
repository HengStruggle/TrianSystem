import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.dbDesign.Exception.UserExistException;
import com.dbDesign.dataBase.DBHelper;
import com.dbDesign.json.SeatInfo;
import com.dbDesign.json.TicketInfo;
import com.dbDesign.json.User;
import com.dbDesign.service.Function;
import com.dbDesign.service.ISeatInfoService;
import com.dbDesign.service.ITicketInfoService;
import com.dbDesign.service.ITrainInfoService;
import com.dbDesign.service.IUserService;
import com.dbDesign.service.impl.SeatInfoService;
import com.dbDesign.service.impl.TicketInfoService;
import com.dbDesign.service.impl.TrianInfoService;
import com.dbDesign.service.impl.UserService;
import com.dbDesign.util.SqlUtils;

public class Demo {

	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	/**
	 * @param args
	 * @throws UserExistException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws UserExistException,
			ParseException {

//		 User user = new User();
//		
//		 // 获取用户填写的登录用户名
//		 String username = "xieyong";
//		 // 获取用户填写的登录密码
//		 String password = "234";
//		 // 获取用户的角色
//		 String userRole = "guest";
//		 user.setUserName(username);
//			user.setPassword(password);
//			user.setRole(userRole);
//			
//				IUserService service = new UserService();
//				// 调用service层提供的注册用户服务实现用户注册
//				service.registerUser(user);
		//
		// IUserService service = new UserService();
		// // 用户登录
		// user = service.loginUser(username, password, userRole);
		// if(user!=null){
		// System.out.println("登录成功！");
		// }
		//
		// String year = "1995";
		// String month = "12";
		// String day = "30";
		// //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// //java.util.Date date = sdf.parse(year+"-"+month+"-"+day);
		// Date date = Date.valueOf(year+"-"+month+"-"+day);
		//try {
			// String trianNo = "G302";
			// String departure = "广州";
			// String terminal = "潮汕";
			// String year = "1995";
			// String month = "12";
			// String day = "30";
			// String hour = "12";
			// String minute = "30";
			// String second = "12";
			//
			// String values = SqlUtils.addQuot(trianNo)
			// + ","
			// + SqlUtils.addQuot(departure)
			// + ","
			// + SqlUtils.addQuot(terminal)
			// + ","
			// + SqlUtils.addQuot(SqlUtils.valueOfDate(year, month, day))
			// + ","
			// + SqlUtils.addQuot(SqlUtils.valueOfDate(year, month, day)
			// + " " + SqlUtils.valueOfTime(hour, minute, second));
			// String sql = MessageFormat.format(SqlUtils.INSERT_TABLE, "train",
			// values);
			// System.out.println(sql);
			//
//			 conn = DBHelper.getConnection();
			// conn.prepareStatement(sql).executeUpdate();
			// System.out.println("注册成功");

			// conn = DBHelper.getConnection();
			//
			// String sql = "select * from train";
			// ps = conn.prepareStatement(sql);
			// rs = ps.executeQuery();
			// System.out.println("车次号\t始发站\t终点站\t发车时间\t到达时间");
			// while (rs.next()) {
			// System.out.println(rs.getString(1) + "\t" + rs.getString(2)
			// + "\t" + rs.getString(3) + "\t" + rs.getString(4)
			// + "\t" + rs.getString(5));
			// }

//			 String departure = "惠州南";
//			 String terminal = "深圳北";
//			 String year = "2016";
//			 String month = "01";
//			 String day = "11";
//			 String startDate = SqlUtils.valueOfDate(year, month, day);
//			
//			 ITrainInfoService serviced = new TrianInfoService();
//			 // 查看数据库返回数据数组
//			 JSONArray result = serviced.checkTrain(departure, terminal,
//			 startDate.toString());
//			 if (result != null) {
//			 for (int i = 0; i < result.size(); i++) {
//			 JSONObject obj = (JSONObject) result.get(i);
//			 System.out.println(obj.get("train_no")
//			 + obj.getString("departure") + obj.get("terminal")
//			 + obj.getString("startDate")
//			 + obj.getString("startTime")
//			 + obj.getString("arrivalTime")
//			 + obj.getInt("business_sum")
//			 + obj.getInt("business_price")
//			 + obj.getString("first_sum")
//			 + obj.getInt("first_price")
//			 + obj.getInt("second_sum")
//			 + obj.getInt("second_price"));
//			 }
		
//		 // 获取用户填写的登录用户名
//		 String username = "谢泳";
//		 // 获取用户填写的登录密码
//		 String password = "123";
//		 // 获取用户的角色
//		 String userRole = "guest";
//		
//				User user = null;
//			 IUserService service = new UserService();
//				// 用户登录
//				user = service.loginUser(username, password, userRole);
			 
//			conn = DBHelper.getConnection();

//			String trainNo = "G6303";
//			String startDate = "2016-01-10";
//			int seatLevel = 1;
//
//			ISeatInfoService seatService = new SeatInfoService();
//			ITicketInfoService ticketService = new TicketInfoService();
//
//			SeatInfo seatInfo = seatService.allocSeat(trainNo, startDate,
//					seatLevel);
//			if (seatInfo != null) {
//				System.out.println(seatInfo.getSeatNo());
//			} else {
//				System.out.println("fail");
//			}
//
//			TicketInfo ticketInfo = new TicketInfo();
//			String userName = "蔡岳衡";
//			ticketInfo.setUserName(userName);
//			ticketInfo.setTrainNo(trainNo);
//			ticketInfo.setStartDate(startDate);
//
//			String startTime = "12:54:00";
//			ticketInfo.setStartTime(startTime);
//
//			String seatNo = seatInfo.getSeatNo();
//			ticketInfo.setSeatNo(seatNo);
//
//			ticketInfo.setSeatLevel(seatLevel);
//			int ticketPrice = seatInfo.getTicketPrice();
//			ticketInfo.setTicketPrice(ticketPrice);
//			if (ticketService.userAddTicket(ticketInfo) == true) {
//				if (seatService.useSeat(trainNo, seatNo, startDate) == true) {
//					System.out.println("fail");
//				}
//			} else {
//				System.out.println("fail");
//			}
			
//			String userName = "蔡岳衡";
//			
//			ITicketInfoService ticketService = new TicketInfoService();
//			JSONArray result = ticketService.userCheckTicket(userName);
//			
//			 if (result != null) {
//					 for (int i = 0; i < result.size(); i++) {
//					 JSONObject obj = (JSONObject) result.get(i);
//					 System.out.println(obj.get("username")
//					 + obj.getString("train_no") + obj.get("seat_no")
//					 + obj.getString("startdate")
//					 + obj.getString("starttime")
//					 + obj.getString("arrivalTime")
//					 + obj.getInt("business_sum")
//					 + obj.getInt("business_price")
//					 + obj.getString("first_sum")
//					 + obj.getInt("first_price")
//					 + obj.getInt("second_sum")
//					 + obj.getInt("second_price"));
//					 }
//			
//			
				String userName = "蔡岳衡";

				ITicketInfoService ticketService = new TicketInfoService();
			
				//if (order.equals(ORDER_CHECK)) {
					JSONArray resultArray = ticketService.userCheckTicket(userName);
			 
			 
			 
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBHelper.release(conn, ps, rs);
	}
}

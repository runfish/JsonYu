package com.dp.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.dp.utils.BaseAction;
import com.dp.utils.JDBCUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ReportAction extends BaseAction {

	private String reportTitle;

	private String reportContext;

	private List<File> rider;

	private String riderFileName;

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getReportContext() {
		return reportContext;
	}

	public void setReportContext(String reportContext) {
		this.reportContext = reportContext;
	}

	public List<File> getRider() {
		return rider;
	}

	public void setRider(List<File> rider) {
		this.rider = rider;
	}

	public String getRiderFileName() {
		return riderFileName;
	}

	public void setRiderFileName(String riderFileName) {
		this.riderFileName = riderFileName;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String save() {

		String uploadDir = servletContext.getRealPath("/uploadFiles");

		String[] fileNames = null;

		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy_MM-dd");

		OutputStream outputStream = null;

		InputStream inputStream = null;

		Connection conn = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;

		String sql = "";

		String[] filePaths = null;
		System.out.println(this.rider);
		if (this.rider != null) {

			if (rider.size() == 1) {
				fileNames = new String[1];
				fileNames[0] = this.riderFileName;
			} else {
				fileNames = this.riderFileName.split(",");
			}
			filePaths = new String[rider.size()];
			for (int i = 0; i < this.rider.size(); i++) {
				String filePath = System.currentTimeMillis()
						+ fileNames[i].substring(fileNames[i].lastIndexOf("."));
				filePaths[i] = filePath;
				try {
					outputStream = new FileOutputStream(uploadDir + "/"
							+ filePath);
					inputStream = new FileInputStream(rider.get(i));
					
					int j = 0;

					byte[] b = new byte[10240];

					while ((j = inputStream.read(b, 0, 10240)) != -1) {
						outputStream.write(b, 0, j);
						outputStream.flush();
					}

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {

					try {
						inputStream.close();
						outputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		try {

			conn = JDBCUtils.getConn();

			sql = "insert into report(report_id,report_title,report_time,report_context) values(seq_report_id.nextval,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, this.reportTitle);

			pstmt.setString(2, sDateFormat.format(new Date()));

			pstmt.setString(3, this.reportContext);

			pstmt.execute();
			if (this.rider != null) {
				sql = "select * from report order by report_id desc";

				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();

				int id = 0;

				if (rs.next()) {
					id = rs.getInt(1);
				}

				sql = "insert into rider(rider_id,report_id,rider_name,rider_url) values(seq_rider_id.nextval,?,?,?)";

				pstmt = conn.prepareStatement(sql);
				
				for (int i = 0; i < this.rider.size(); i++) {

					pstmt.setInt(1, id);
					pstmt.setString(2, fileNames[i]);
					pstmt.setString(3, filePaths[i]);
					pstmt.executeUpdate();

				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			JDBCUtils.closeRes(null, rs);
			try {
				pstmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return "succ";
	}
}

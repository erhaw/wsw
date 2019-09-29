package com.personal.cloud.controller.demo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class HttpClient {

	public static byte[] post(String urlPath, byte[] bytes, String contentType) throws IOException {
		URL url = new URL(urlPath);

		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setConnectTimeout(3000); // 设置连接超时时间
		httpURLConnection.setDoInput(true); // 打开输入流，以便从服务器获取数据
		httpURLConnection.setDoOutput(true); // 打开输出流，以便向服务器提交数据
		httpURLConnection.setRequestMethod("POST"); // 设置以Post方式提交数据
		httpURLConnection.setUseCaches(false); // 使用Post方式不能使用缓存
		// 设置请求体的长度
		httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
		// 获得输出流，向服务器写入数据
		OutputStream outputStream = httpURLConnection.getOutputStream();
		outputStream.write(bytes);

		int response = httpURLConnection.getResponseCode(); // 获得服务器的响应码
		if (response == HttpURLConnection.HTTP_OK) {
			InputStream inptStream = httpURLConnection.getInputStream();
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			byte[] data = new byte[1024];
			int len = 0;
			try {
				while ((len = inptStream.read(data)) != -1) {
					byteArrayOutputStream.write(data, 0, len);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return byteArrayOutputStream.toByteArray(); // 处理服务器的响应结果
		}
		return null;
	}

	public static void main(String[] args) throws IOException {
//			byte[] request = {65, 66, 77, 0, 67, 33, 96, 33, 53, 56, 88, 78, 5, -39, -1, 55, -119, -122, 6, 23, 3, 0, 72, 3, -111, 83, -106, -83, -2, 6, -80, 37, 9, 2, 100, 3, -36, 0, 10, 0, 32, 3, -68, 2, -56, 0, 23, 25, 0, 0, 4, 0, 0, 30, 10, -94, 13, 0, 0, 30, 10, -94, 13, 0, 0, 30, 10, -94, 13, 0, 0, 30, 10, -94, 13, -75, 125};
//			byte[] request = {65, 66, 30, 0, 67, 8, 121, 7, 56, 57, 65, 80, 5, -41, -1, 57, 88, 84, 48, 48, 48, 48, 48, 48, 48, 48, 49, 0, 3, -102};
			byte[] request = {65, 66, 34, 0, 67, 16, 101, 23, 56, 52, 78, 77, 5, -41, -1, 52, 3, 0, 0, 0, 49, 56, 48, 51, 54, 51, 53, 54, 53, 49, 48, 0, 51, 33};
			for (int i = 0; i < 100; i++) {
				try {
//					byte[] data = HttpClient.post("http://180.76.149.83:8088/f1/verification", request, null);
					byte[] data = HttpClient.post("http://10.10.11.93:8092/smj/netpay", request, null);
					System.out.println(Arrays.toString(data));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
}

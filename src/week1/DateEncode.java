package week1;

public class DateEncode {
	/* mã hóa */
	public static int encodeDate(int day, int month, int year) {
		System.out.println("day:"+Integer.toBinaryString(day));
		System.out.println("month:"+Integer.toBinaryString(month));
		System.out.println("year:"+Integer.toBinaryString(year));
		/*
		 * int a = 60 => 0011 1100;
		 * int b = 13 => 0000 1101;
		 * int c = a|b => 00111101;
		 * dùng "|" để nối giá trị với nhau và dùng << để dịch giá trị để không bị trùng nhau
		 * vd : 010 << 2 => 1000
		 * tháng dịch bit ra 5 để này không bị trùng với ngày
		 * năm dịch bit ra 9 để không bị trùng với này và tháng
		 * tham khảo bài viết : https://vietjack.com/java/vi_du_toan_tu_thao_tac_bit_trong_java.jsp
		 */
		return day|month<<5|year<<(9);
	}
	/* giải mã*/
	public static String decodeDate(int dateEncode) {
		int year=dateEncode>>(9);
		// giải thích: lúc nãy dịch 9 bit nên bước này trả lại giá trị củ
		
		
		int month=(dateEncode&(15<<5))>>5;
		
		/*
		 * dateEncode&(15<<5) => tẩy giá trị của năm đi vì năm ở trước sẽ ảnh hưởng kết quả
		 * int a = 0101 0010;
		 * int b = 0111 0000;
		 * int c = a&b => 0101 0000 
		 * đồng thời dịch bit về 5 nên trả về chỗ củ
		 */
		
		int day=dateEncode&31;
		
		/*
		 * tương tự như tháng bước này là xóa giá trị của tháng và năm
		 * tại sao là 31 mà không phải số khác để xóa giá trị vì:
		 * 31 => 0001 1111
		 * và ngày không bị dịch bit nên k cần phải dịch bit ngược lại
		 */
	
		return year+"-"+month+"-"+day;

	}
	public static void main(String[] args) {
		int encode =encodeDate(28,10,2021);
		System.out.println("encode: "+encode);
		
		System.out.println("Encode to Binary String: "+Integer.toBinaryString(encode));
		
		String decode = decodeDate(encode);
		System.out.println("encodeDate: "+decode);
	}

}

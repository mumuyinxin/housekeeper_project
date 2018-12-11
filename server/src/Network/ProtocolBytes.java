package Network;


public class ProtocolBytes {
	
	public byte[] bytes;
	
	public ProtocolBytes Decode(byte[] readBuff, int start, int length) {
		ProtocolBytes protocol = new ProtocolBytes();
		protocol.bytes = new byte[length];
		System.arraycopy(readBuff, start, protocol.bytes, 0, length);
		return protocol;
	}
	
	public byte[] Encode() {
		return bytes;
	}
	
	public String GetName() {
		return GetString(0);
	}
	
	public String GetDesc() {
		String str = "";
		if(bytes == null) {
			return str;
		}
		for (int i = 0; i < bytes.length; i++) {
			int b = (int)bytes [i];
			str +=  Integer.toString(b) + " ";
		}
		return str;
	}
	
	public String GetString(int start) {
		return null;
	}
	
	public void AddString(String str) {
		int len = str.length();
		byte[] lenBytes = intToByteArray(len);
		byte[] strBytes = str.getBytes();
		if(bytes == null) {
			bytes = unitByteArray(lenBytes, strBytes, 0);
		}else {
			int bytesLen = bytes.length;
			bytes = unitByteArray(lenBytes, strBytes, bytesLen);
		}
	}
	
	public static byte[] intToByteArray(int a) {   
		return new byte[] {   
		        (byte) ((a >> 24) & 0xFF),   
		        (byte) ((a >> 16) & 0xFF),      
		        (byte) ((a >> 8) & 0xFF),      
		        (byte) (a & 0xFF)   
		    };   
		}
	
	public static byte[] unitByteArray(byte[] byte1,byte[] byte2, int start){
        byte[] unitByte = new byte[byte1.length + byte2.length];
        System.arraycopy(byte1, 0, unitByte, start, byte1.length);
        System.arraycopy(byte2, 0, unitByte, byte1.length+start, byte2.length);
        return unitByte;
    }
	
	public String GetStringStart(int start) {
		int end = 0;
		return GetString(start,end);
	}
	
	public String GetString(int start, int end) {
		if(bytes == null) {
			return "";
		}
		if(bytes.length < start + 4) {
			return "";
		}
		
		int strLen = byteArrayToInt(bytes, start);
		if (bytes.length < start + 4 + strLen) {
			return "";
		}
		
		return null;
	}

	public static int byteArrayToInt(byte[] b ,int start) {   
		return b[start+3] & 0xFF |   
		       (b[start+2] & 0xFF) << 8 |   
		       (b[start+1] & 0xFF) << 16 |   
		       (b[start] & 0xFF) << 24;   
	}   
}
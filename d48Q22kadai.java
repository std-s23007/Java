// 23007
// d48Q22のコードをコンパイルエラーしないように修正
enum Connection {
	OFFLINE, ONLINE
}


class d48Q22 {
	public static void main(String[] args) {
		Connection s = Connection.OFFLINE;
		if (s == Connection.OFFLINE) {
			s = Connection.ONLINE;
		}
		System.out.println(s);
	}
}

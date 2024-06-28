// s23007
// ラグビーの試合結果から勝ち点を計算し、表示するプログラム
// 試合結果を表示するプログラムを追記

class d48Q6kadai {
	public static void main(String[] args) {
		if (args.length != 4) { // コマンドラインから与えられたargsの個数が4じゃなかった場合のメッセージ (33) イ
			System.out.println("数値を4つ指定してください");
			return;
		}

		Achievement teamA = new Achievement();
		teamA.set(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		Achievement teamB = new Achievement();
		teamB.set(Integer.parseInt(args[2]), Integer.parseInt(args[3]));

		Match match = new Match();
		match.setAchievements(teamA, teamB); // setAchievementsメソッドを使いteamA,
							// teamBのインスタンスを設定する (34) ゥ
		System.out.println(match.showResult());
		System.out.println(match.winResult());
	}
}


class Match {
	Achievement teamA;
	Achievement teamB;

	void setAchievements(Achievement a, Achievement b) {
		teamA = a;
		teamB = b;
	}

	String showResult() {
		return "TeamA:" + winPoint(teamA.point, teamB.point, teamA.tryNumber) + ", TeamB:"
				+ winPoint(teamB.point, teamA.point, teamB.tryNumber);
	}

	String winResult() {
		int teamAPoints = winPoint(teamA.point, teamB.point, teamA.tryNumber);
		int teamBPoints = winPoint(teamB.point, teamA.point, teamB.tryNumber);

		if (teamAPoints > teamBPoints) {
			return "チームAの勝利";
		} else if (teamAPoints < teamBPoints) {
			return "チームBの勝利";
		} else {
			return "引き分け";
		}
	}

	int winPoint(int teamXPoint, int teamYPoint, int teamXTryNumber) {
		return matchPoint(teamXPoint, teamYPoint) + bonusPoint(teamXTryNumber); // (35) ゥ
	}

	int matchPoint(int teamXPoint, int teamYPoint) {
		if (teamXPoint == teamYPoint) {
			return 2;
		} else if (teamXPoint > teamYPoint) {
			return 4;
		} else if (teamYPoint - teamXPoint <= 7) { // (36) ゥ 敗北した場合でも、得点差が７点以内の場合は１点と表示する
			return 1;
		}
		return 0;
	}

	int bonusPoint(int tryNumber) {
		return tryNumber >= 4 ? 1 : 0; // (37) ェ if文の参考演算子４以上であればTrue,４未満であればFalse
	}
	}


class Achievement {
	int point;
	int tryNumber;

	void set(int teamPoint, int teamTryNumber) {
		point = teamPoint;
		tryNumber = teamTryNumber;
	}
}

/**
 * 
 * 丢手绢问题（约瑟夫问题）
 * 
 * 有M个人，其编号分别为1－M。这M个人按顺序排成一个圈。
 * 现在给定一个数N，从第一个人开始依次报数，数到N的人出列，
 * 然后又从下一个人开始又从1开始依次报数，
 * 数到N的人又出列．．．如此循环，直到最后所有人出列为止。
 * 输出出列轨迹。
 * 
 * eg: java JosephusProblem 5 4
 * 
 * @author 卜华阳
 *
 */
public class JosephusProblem {

	public static void main(String[] args) {
		if (args.length != 2) { // 处理参数数目不正确情况
			System.out.println("Please Input a number!");
			return;
		}
		int i, j, n, m;
		n = Integer.parseInt(args[0]);
		m = Integer.parseInt(args[1]);
		if (n <= 0 || m <= 0) { // 处理参数值不正确的情况
			System.out.println("Paramter must bigger than zero!");
			return;
		}
		int a[] = new int[n];
		for (i = 0; i < n; i++)
			a[i] = i + 1;
		int k = 1; // 标识处理第k个离开的人
		i = -1; // 数组下标,下一个为0,即第一个人
		while (true) { // k等于n表示只剩下一个人了
			for (j = 0; j < m;) { // 在圈中数m个人
				i = (i + 1) % n;
				if (a[i] > 0)
					j++; // a[i] >0表示第i个人还没有离开
			}
			if (k == n)
				break;
			System.out.println("No." + a[i] + " is out!");
			a[i] = -1; // 表示该人离开
			k++;
		}
		System.out.println("No." + a[i] + " is the winner!");
	}

}

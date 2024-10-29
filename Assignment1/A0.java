package Assignment1;
import java.util.*;
import java.math.*;

public class A0 {
	public static void main(String[] args) {
		System.out.println("Hello World 2ME3!");
		
		examples();
		examples2();
		examples3();
		System.out.println("End of all examples.");
	}
	public static void examples()
	{
		//integer ------------------------
		int i = 0;
		long l = 10l;
		short s = 0; //no suffix indicator
		System.out.println("int bytes: " + Integer.BYTES);
		System.out.println("long bytes: " + Long.BYTES);
		System.out.println("short bytes: " + Short.BYTES);
				
		int b = 0b10;//2-base
		int h = 0x10;//16-base
		int o = 010;//8-base
		System.out.println("b is " + b);
		System.out.println("h is " + h);
		System.out.println("o is " + o);
		
		int iSep = 1_000_000;
		System.out.println("iSep is " + iSep);
		
		//float ------------------------
		float f = 10.1f;
		double d = 10.1;
		System.out.println("float bytes: " + Float.BYTES);
		System.out.println("double bytes: " + Double.BYTES);
		
		//char ------------------------
		char ch = 'a';
		System.out.println("ch: " + ch + " int value: " + (int)ch);
		for(ch = 'A'; ch != 'Z'; ch = (char)((int)ch+1))
		{
			System.out.println("ch: " + ch + " int value: " + (int)ch);
		}
		
		char ch2 = '\u0041';
		System.out.println("ch2: " + ch2);
		
		char ch3 = '\'';
		System.out.println("ch3: " + ch3);
		
		//boolean ------------------------	
		boolean succeed = true;
		boolean bl = (2==1);
		if (succeed)
		{
			//...
		}
		

		//variable and constant ------------------------
		double salary = 14000.0;
		salary = 22000.0;
		final int cons = 3;
		//cons = 5;
		//cons = 6;
		
		double $_a123s = 435;
		System.out.println($_a123s);
		
		//enum ------------------------
		enum Size {SMALL, MEDIUM, LARGE, EXTRA_LARGE};
		Size sz = Size.SMALL; 
		System.out.println("sz is: " + sz);
		
		//operator ------------------------
		//arithmetic:
		float div = 15 /2;
		System.out.println("div is: " + div);
	}
	
	public static void examples2()
	{ 	
		//assignment ------------------------
		int x = 1;
		x += 4;
		System.out.println("x is: " + x);
		
		x=1;
		int y = x += 4;
		System.out.println("y is: " + y);
		
		x=1;
		x += 3.5;
		System.out.println("x is: " + x);
				
		//increment and decrement  ------------------------
		int m = 7;
		//int a = 2 * ++ m;
		int a = 2 * m ++;
		System.out.println("a is: " + a + ", m is: " + m);
		
		//relational logical ------------------------
		x = 0;
		if(x != 0 && 1 / x > 1)//short circuit
		//if(1 / x > 1 && x != 0)
		{
			System.out.println("here is true");
		}
		
		//conditional operator ------------------------
		x=-123;
		int sign = x<0 ? -1 : 1;
		System.out.println("sign is: " + sign);
		
		x = 5; 
		y =10;
		int minValue = x > y ? y : x;
		System.out.println("minValue is: " + minValue);
		
		//switch ------------------------
		int seasonCode = 2;
		String seasonName = switch (seasonCode){
				case 0 -> "Spring";
				case 1 -> "Summer";
				case 2 -> {
					System.out.println("do something in Fall");
					yield "Fall";
					}
				case 3 -> "Winter";
				default -> "???";
		};
		System.out.println("SeasonName is: " + seasonName);
		
		char grade = 'A';
		boolean pass = switch (grade) {
			case 'A', 'B', 'C', 'D' -> true;
			case 'E','F' -> false;
			default -> true;
		};
		System.out.println("pass=" + pass); 
		
		//bitwise operator ------------------------
		int n = 10;
		int fourthBitFromRight = (n & 0b1000) / 0b1000;
		//int fourthBitFromRight = (n & (1 << 3)) >> 3;
		System.out.println("fourthBitFromRight is: " + fourthBitFromRight);
		
		int bitNum = 35;
		int shiftALot = 1 << bitNum;
		int bitLen = 8*Integer.BYTES;//8*4=32bits for int
		int shiftMod = 1 << (bitNum % bitLen);//mod 32
		System.out.println("shiftALot=" + shiftALot + ", shiftMod=" + shiftMod);
		
		x = 0;
		if(x != 0 && 1 / x > 1)//& will crash, && is fine
		{
			System.out.println("here is true");
		}
		
		//order ------------------------
		int b = 3;
		int c = 4;
		int d = 5;
		a = b += c += d;//right to left
		System.out.println("a=" + a + ", b=" + b + ", c=" + c + ", d=" + d);
		
		//string ------------------------
		String greeting = "Hello";
		String name = " Thomas!";
		//String message = greeting + name;
		String message = greeting + name + 12345.78;
		System.out.println("message: " + message);
		
		greeting = "hey";
		String sub = greeting.substring(0, 3);//[beginIdx, endIdx)
		System.out.println("sub="+sub);
		int lenGreeting = greeting.length();
		int lenSub = sub.length();
		if (greeting.equals(sub))
			System.out.println("greeting equals to sub: " + greeting); 

		//string cmp
		String hello1 = new String("Hello");
		String hello2 = new String("Hello");
		if(hello1.equals(hello2))
			System.out.println("hello1 equals to hello2: " + hello1);
		else
			System.out.println("hello1 does not equal to hello2");
		
		if(hello1 == hello2)//not necessarily true
			System.out.println("hello1 == hello2: " + hello1);
		else
			System.out.println("hello1 != hello2");
		
		//empty and null
		String emptyStr = "";
		if (emptyStr.isEmpty())
		//if (emptyStr.length() == 0)
			System.out.println("emptyStr is empty");
		else
			System.out.println("string not empty");
		
		String nullStr = null;
		//if (nullStr.isEmpty())//crash
		//if (nullStr.length() == 0)//crash
		if (nullStr == null)
			System.out.println("nullStr is null");
		else
			System.out.println("string not null");
		
		//StringBuilder
		StringBuilder strBd1 = new StringBuilder();
		StringBuilder strBd2 = new StringBuilder("dog");
		StringBuilder strBd3 = new StringBuilder(10);
		System.out.println("strBd1 = " + strBd1.toString());
		System.out.println("strBd2 = " + strBd2.toString());
		System.out.println("strBd3 = " + strBd3.toString());
		
		strBd1.append("abc");
		strBd1.append("_def");
		System.out.println("strBd1 = " + strBd1.toString());
		strBd2.setCharAt(2, 't');//dog -> dot
		strBd2.setCharAt(0, 'h');//dot -> hot
		System.out.println("strBd2 = " + strBd2.toString());
		
		//textblock
		String strLine = "Hello\nWorld\n";
		String textBlock = """
				Hello
				    World
				""";
		System.out.println("strLine is:\n" + strLine);
		System.out.println("textBlock is:\n" + textBlock);
		
		String textBlock2 = """
				I said "Hello
				World"
				""";
		System.out.println("textBlock2 is:\n" + textBlock2);
	}
	
	public static void examples3()
	{
		//reading input  ------------------------
		Scanner input = new Scanner(System.in);
		System.out.print("What's your name?");
		String name = input.nextLine();
		System.out.println("Hello " + name);
		
		System.out.print("Which year are you in?");
		int age = input.nextInt();
		System.out.println("Next year you'll be at " + (age+1) + " year");
		
		//formatting output  ------------------------
		System.out.printf("%d\n", 16);//integer
		System.out.printf("%x\n", 16);//hex
		System.out.printf("%o\n", 16);//oct
		System.out.printf("%e\n", 16.0);//exponential floating point number
		System.out.printf("%c\n", 65);//char
		System.out.printf("%b\n", 0==1);//bool false
		System.out.printf("%b\n", 1==1);//bool true
		
		name = "Yingying";
		age = 18;
		System.out.printf("Hello %s, next year you'll be %d years old\n", 
				name, age);
		
		double x = 123.4567;
		System.out.println(x);
		System.out.printf("%8.2f\n", x);//8 width, 2 digits after decimal point
			
		//code block  ------------------------
		int o;
		{
			int i;
			//int o;
		} 
		//i = 5;
		
		//if-else  ------------------------
		int sign = 1;
		x = 123;
		if (x <= 0) if (x==0) sign = 0; else sign = -1;
		System.out.println("sign is: "+ sign);
		
		if (x <= 0) {if (x==0) sign = 0; else sign = -1;}
		System.out.println("sign is: "+ sign);
		
		if (x <= 0) {if (x==0) sign = 0;} else sign = -1;
		System.out.println("sign is: "+ sign);
		
		//switch  ------------------------
		System.out.println("switch->");
		String program = "undergrad";
		switch (program)
		{
		case "undergrad" ->
			System.out.println("U");
		case "ms", "phd"->
			System.out.println("G");
		default ->
			System.out.println("high school?");
		}
		
		System.out.println("switch :");
		switch (program)
		{
		case "undergrad":
			System.out.println("U");
			break;
		case "ms", "phd":
			System.out.println("G");
			break;
		default:
			System.out.println("high school?");
		}
				
		//while & do while  ------------------------
		System.out.print("while-loop fib: ");
		int fib0=0, fib1=1;
		int i = 0;
		while(i++ < 5)
		{
			int next = fib1 + fib0;
			//shift
			fib0 = fib1;
			fib1 = next;
			System.out.print(fib1 + ",");
		}
		System.out.println("");
		
		System.out.print("do-while-loop fib: ");
		fib0=0;
		fib1=1;
		i = 0;
		do {
			int next = fib1 + fib0;
			//shift
			fib0 = fib1;
			fib1 = next;
			System.out.print(fib1 + ",");
		} while(i ++ < 4);
		System.out.println("");
		
		System.out.print("while(true)-loop fib: ");
		fib0=0;
		fib1=1;
		i = 0;
		while(true)
		{
			if(i++ >= 5)
				break;
			int next = fib1 + fib0;
			//shift
			fib0 = fib1;
			fib1 = next;
			System.out.print(fib1 + ",");
		}
		System.out.println("");
		
		//for-loop  ------------------------
		System.out.print("for-loop fib: ");
		fib0=0; 
		fib1=1;
		for(int it=0; it < 5; ++ it)
		{
			int next = fib1 + fib0;
			//shift
			fib0 = fib1;
			fib1 = next;
			System.out.print(fib1 + ",");
		}//outside for loop, it is no longer defined here
		
		for(int it=0; it < 10; ++ it)
		{}
		System.out.println("");
		
		//break and continue  ------------------------
		int wi = 0;
		outOfWhile:
		while(wi++ < 2)
		{
			System.out.print("..while wi=" + wi);
			for(int fi = 0; fi < 3; ++ fi)
			{
				System.out.print("\n....for fi=" + fi);
				System.out.print(", wi=" + wi);
				//break outOfWhile;
			}
			System.out.print("\n..end\n");
		}
		System.out.println("\nOutside while");
		
		//functions and overloading   ------------------------
		func1();//boolean func1()
		func1(1, 2.0);//boolean func1(int arg1, double arg2)
		func1(2.0);//boolean func1(double arg1)
		func1(1);//boolean func1(int arg1)
		
		//big number   ------------------------
		//don't forget to import math first
		BigInteger regularBig = BigInteger.valueOf(100);
		System.out.println("regularBig=\t"+regularBig);
		
		BigInteger veryBig = new BigInteger("222232244629420445529739893461909967206666939096499764990979600");
		System.out.println("veryBig=\t"+veryBig);
		
		veryBig = veryBig.add(regularBig);
		System.out.println("veryBig=\t"+veryBig);
		
		BigDecimal veryBigFloat = new BigDecimal("222232244629420445529739893461909967206666939096499764990979600.123");
		System.out.println("veryBigFloat=\t"+veryBigFloat);
		
		//arrays  ------------------------
		int[] arr;
		int[] arr2 = new int[7];  
		int arr3[] = new int[7]; 
		for(int arrElement : arr2)
		{
			System.out.print(arrElement + ",");
		}
		System.out.println("");
		
		int capacity = i+3;
		capacity ++;
		int[] arr4 = new int[capacity]; 
		System.out.println("length of arr4: " + arr4.length);
		
		int[] arr5 = { 2, 3, 5, 7, 11, 13 };
		System.out.println("length of arr5: " + arr5.length);
		for(int index=0; index < arr5.length; ++ index)
		{
			System.out.print(arr5[index] + ",");
		}
		System.out.println("");
		
		int[] arr6 = new int[] { 37, 29, 31, 23, 17, 19 };
		System.out.println("arr6:" + Arrays.toString(arr6));
		
		int[] arr7 = Arrays.copyOf(arr6, arr6.length);//copy value
		System.out.println("arr7:" + Arrays.toString(arr7));
		int[] arr8 = arr7;//the same array
		System.out.println("arr8:" + Arrays.toString(arr8));
		
		System.out.println("sort ...");
		Arrays.sort(arr7);
		System.out.println("arr6:" + Arrays.toString(arr6));
		System.out.println("arr7:" + Arrays.toString(arr7));
		System.out.println("arr8:" + Arrays.toString(arr8));
		
		//multi-dim
		float [][] matrix = new float[3][3];
		float [][] matrixId =
			{{1, 0, 0},
			{0, 1, 0},
			{0, 0, 1}};
		float [][] matrix2 = new float [][] 
			{{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}};
		
		System.out.println("matrix2 length: " + matrix2.length);
		for(int ri=0; ri < matrix2.length; ++ ri) 
			System.out.println("row" + ri + ": " + Arrays.toString(matrix2[ri])); 
			
		System.out.println("matrix2:" + Arrays.toString(matrix2));
		
		//ragged
		for(int ri=0; ri < 3; ++ ri)
			matrix[ri] = new float[ri]; //matrix row ri is of length ri
		System.out.println("matrix length: " + matrix.length);
		for(int ri=0; ri < matrix.length; ++ ri) 
			System.out.println("row" + ri + ": " + Arrays.toString(matrix[ri]));
	
	}

	
	public static boolean func1()
	{
		System.out.println("in boolean func1()");
		return true;
	}
	
	public static boolean func1(int arg1)
	{
		System.out.println("in boolean func1(int arg1)");
		return true;
	}
	
	public static boolean func1(int arg1, double arg2)
	{
		System.out.println("in boolean func1(int arg1, double arg2)");
		return true;
	}
	
	public static boolean func1(double arg1)
	{
		System.out.println("in boolean func1(double arg1)");
		return true;
	}
	
	/*public static int func1(double arg1)
	{
		System.out.println("in boolean func1(double arg1)");
		return true;
	}*/
}

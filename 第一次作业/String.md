# String用法

## String的``Equal``与``==``
* 一个String对象赋初值后不可修改
* ``==``——same object
* ``equal`` contains same char array

``String s1="hello"``

``String s2="hello"``

__在运行时，==和equal比较都为true：__
Java编译器在编译期，会自动把所有相同的字符串当作一个对象放入常量池，因此s1和s2的引用相同。

``String s1="hello"``

``String s2="HELLO".toLowerCase()``

此时==为false，equal为true




****
## trim()方法
可以移除字符串首尾空白字符（返回一个新字符串）

``"\tHello\r\n".trim();``//"Hello"

isEmpty()——是否为空
isBlank()——是否为空白字符串

****

## 分割字符串
split()方法

__需要使用正则表达式__

``String s = "A,B,C,D";``
``String[] ss = s.split("\\,"); ``//{"A","B","C","D"}

## 拼接字符串
join()方法——用指定的字符串连接字符串数组

``String[] arr = {"A", "B", "C"};``
``String s = String.join("+", arr); ``// "A+B+C"

*****
## 格式化字符串

formatted()和format()静态方法
 
    public class Main {
    public static void main(String[] args) {
        String s = "Hi %s, your score is %d!";
        System.out.println(s.formatted("Alice", 80));
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));
    }
    }

其中：
* %s：显示字符串；
* %d：显示整数；
* %x：显示十六进制整数；
* %f：显示浮点数。


## 转换类型
 * 其他类型转为String：

     String.valueOf(参数);
     
 * String转为其他类型

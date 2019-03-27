package SJ_4.FruitStoreObj.Manager;

/**
 * 类描述了
 * <p>
 * <p>
 * <p>
 * 修改时间： 2019/3/26
 *
 * @author shenyingming tel:18076220793
 * @version 1.0 <br>
 */

import SJ_4.FruitStoreObj.pojo.Apple;
import SJ_4.FruitStoreObj.pojo.Banana;
import SJ_4.FruitStoreObj.pojo.Fruit;
import SJ_4.FruitStoreObj.pojo.Orange;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 数据处理
 * 利用数组装数据
 * 对数据的增，删，改，查
 */
public class Manager {
    //新建水果数组
    public static Fruit fruits[] = new Fruit[5];
    //申明变量表示数组里的水果条数，初始化为零
    public static int counts = 0;

    //【添加数组元素】,只需要录入水果id和数量
    public void addFruit(int i, Scanner sc) {
        if (counts < 5) {
            switch (i) {
                case 1:
                    //提示输入数量
                    System.out.println("请输入苹果数量：");
                    fruits[counts] = new Apple(i, sc.nextInt());
                    counts++;
                    break;
                case 2:
                    //提示输入数量
                    System.out.println("请输入橘子数量：");
                    fruits[counts] = new Orange(i, sc.nextInt());
                    counts++;
                    break;
                case 3:
                    //提示输入数量
                    System.out.println("请输入香蕉数量：");
                    fruits[counts] = new Banana(i, sc.nextInt());
                    counts++;
                    break;
                default:
                    System.out.println("商品编号为1至3！本次录入不成功！");
                    break;
            }

        }
    }



    /**
     * 打印水果菜单
     */
    public void BuyFruits(Scanner sc) {
        //水果菜单
        fruitsList();
        //提示用户选择
        System.out.println("请输入编号：");
        switch (sc.nextInt()) {
            case 1:
                addFruit(1,  sc);  //买苹果
                break;
            case 2:
                addFruit(2, sc);    //买香蕉
                break;
            case 3:
                addFruit(3, sc);    //买橘子
                break;
            case 4:
                printfruits();     //打印已选中的商品
                break;
            default:
                System.out.println("你的输入有误！");
                break;

        }
        //询问用户是否继续
        System.out.println("继续选择y/按任意键回主菜单");
        if (sc.next().equals("y")) {
            BuyFruits(sc); //如果用户选择y就递归调用继续选择
        }
    }

    /**
     * 打印水果菜单
     */
    public void fruitsList() {
        System.out.println("***********今日鲜品***********");
        System.out.println("[1]     苹果      ￥8.8！！");
        System.out.println("[2]     香蕉      ￥3.3！！");
        System.out.println("[3]     橘子      ￥5.0！！");
        System.out.println("[4] 显示已选");
        System.out.println("******************************");
    }

    /**
     * 结账
     */
    public void PayOff(Scanner sc) {
        //显示消费总额
        double tol = Manager.TotalCharge();  //消费总额
        System.out.println("您的消费总额为：￥" + tol);
        boolean flag = false;
        do {
            //输入用户金额
            System.out.println("请输入您的😊🙉金额：");
            double RMB = sc.nextDouble();
            //结算
            if (RMB > tol) {
                System.out.println("收您：￥" + RMB +
                        "\t消费：￥" + tol +
                        "\t找零：￥" + (RMB - tol));
            } else {
                flag = true;   //金额不足需重新输入
                System.out.println("对不起，金额不足！");
            }
        } while (flag);
    }

    //打印小票

    public void PrintList(Scanner sc) {

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ssE");
        double toltal = Manager.TotalCharge();   //double类型的计算要注意小数
        DecimalFormat df = new DecimalFormat("#0.00");
        String tol = df.format(toltal);    //返回值为string类型

        System.out.println("************欢迎光临不要钱水果摊儿************");
        System.out.println("您购买了如下商品:________________________");
        System.out.println(Manager.fruitsIfo());   //商品信息
        System.out.println("总花费：￥" + df.format(toltal));
        System.out.println("当前日期：\t\t" + sd.format(new Date()));
        System.out.println("***************************大冲分店祝您生活愉快");

    }

    //计算数组内商品总价
    public static double TotalCharge() {
        double charge = 0;

        for (int i = 0; i < counts; i++) {
            charge += fruits[i].getPrice() * fruits[i].getCouunt();   //单价乘数量
        }
        return charge;
    }

    //打印已选择
    public void printfruits() {
        System.out.println(fruitsIfo());
    }

    //打印数组信息
    public static String fruitsIfo() {
        StringBuffer info = new StringBuffer("");
        for (int i = 0; i < fruits.length; i++) {
            if (fruits[i] != null) {
                info.append(fruits[i].toString() + "\n");
            }
        }
        return new String(info);
    }
}

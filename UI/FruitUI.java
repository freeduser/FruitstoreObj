package SJ_4.FruitStoreObj.UI;

import SJ_4.FruitStoreObj.Manager.Manager;

import java.util.Scanner;

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
public class FruitUI {
    private Scanner sc = new Scanner(System.in);
    //调用管理类的方法，属性，实例化管理类对象
    Manager fruitmanager = new Manager();

    //打印菜单
    public void showChoices() {
        System.out.println("==========水果超市==========");
        System.out.println("【1】购买水果");
        System.out.println("【2】结账");
        System.out.println("【3】打印小票");
        System.out.println("【4】退出系统");
        System.out.println("============================");
    }

    /**
     * 选择水果
     * 此方法要对数组进行操作，引入mananer的Fruit【】数组
     */
    public void userSelect(Scanner sc) {
        //先显示
        showChoices();
        //提示输入选项
        System.out.println("请输入相应选项：");
        int inpo = sc.nextInt();
        switch (inpo) {
            case 1:
                //购买水果
                fruitmanager.BuyFruits(sc);
                break;
            case 2:
                //结账
                fruitmanager.PayOff(sc);
                break;
            case 3:
                //打印小票
                fruitmanager.PrintList(sc);
                break;
            case 4:
                //退出系统
                System.exit(0);
                break;
            default:
                System.out.println("你的选择有误！");
                break;
        }
        System.out.println("是否继续下一步?(y/n)");
        //用户是否选择
        if (sc.next().equalsIgnoreCase("y")) {
            userSelect(sc);
        }


    }



}

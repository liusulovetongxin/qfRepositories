/**
 * @author Administrator
 * @version V1.0
 * @Project question
 * @Package PACKAGE_NAME
 * @Description:
 * @Date 2022/6/16 23:51
 */

public class Question1 {
    public static void result1(String s){
        String[] split = s.split("\\*");
        if (split != null&&split.length==2) {
            try{
                int split1 = Integer.parseInt(split[0]);
                int split2 = Integer.parseInt(split[1]);
                int[][] nums = new int[split2][split1];
                for (int i = 0; i < split2; i++) {
                    for (int j = 0; j < split1; j++) {
                        if (i%2==0) {
                            nums[i][j] = (i * split1) + j + 1;
                        }else {
                            nums[i][j] = (i * split1) +(split1-j);
                        }
                    }
                }
                for (int i = 0; i < split1; i++) {
                    for (int j = 0; j < split2; j++) {
                        System.err.print(nums[j][i]+ "  ");
                    }
                    System.err.println();
                }
                }catch(Exception e){
                e.printStackTrace();
                }
        }
    }

    public static void main(String[] args) {
        result1("3*5");
    }
}

package bishi;

import java.util.ArrayList;
// 乐学面试题
public class Question4 {

    private int[] typeCount = new int[10];

    public static void main(String[] args) {
        Question4 instance = new Question4();
        instance.printQuestionCount();

    }

    private void printQuestionCount() {
        // 输出样例:type1:13,type2:36,type3:123,...
        // 不要求输出type必须按顺序
        Question root = mockQuestion();
        // 递归
        // 输入当前问题，输出type值。
        // 判断是否有子问题，递归调用。如果无子问题，返回。
        printQuestionType(root);
        for (int i = 0; i < typeCount.length; i++) {
            System.out.println("type" + i + ":" + typeCount[i]);
        }
    }

    // 订单
    // user: uid,name
    // order: oid,uid,price,create_time
    // 2019年下单排行榜
    // name, price总和
    // select name from user where uid in (
    //      select uid from order
    //      order by price
    //      where create_time > 2019 and ..
    // ) and oid =
    // limit 0, 15
    //

    private void printQuestionType(Question root) {
        typeCount[root.type]++;
        if (root.subQuestions == null || root.subQuestions.size() == 0) {
            return;
        } else {
            ArrayList<Question> list = root.subQuestions;
            for (int i = 0; i < list.size(); i++) {
                printQuestionType(list.get(i));
            }
        }
    }


    private Question mockQuestion() {

        Question root = new Question();
        root.type = (int) (Math.random() * 10);
        for (int i = 0; i < 5; i++) {
            Question sq = new Question();
            sq.type = (int) (Math.random() * 10);
            root.subQuestions.add(sq);
            for (int j = 0; j < 5; j++) {
                Question ssq = new Question();
                ssq.type = (int) (Math.random() * 10);
                sq.subQuestions.add(ssq);
                for (int k = 0; k < 5; k++) {
                    Question sssq = new Question();
                    sssq.type = (int) (Math.random() * 10);
                    ssq.subQuestions.add(sssq);
                }
            }
        }
        return root;
    }


    public static class Question {
        // irrelevant
        private String data;
        // type in [0~9]
        private int type;
        // sub question
        private ArrayList<Question> subQuestions = new ArrayList<>();

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public ArrayList<Question> getSubQuestions() {
            return subQuestions;
        }

        public void setSubQuestions(ArrayList<Question> subQuestions) {
            this.subQuestions = subQuestions;
        }
    }
}


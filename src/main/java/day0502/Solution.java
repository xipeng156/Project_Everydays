package day0502;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    //3. 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s){
        int m=0;
        int len = s.length();
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for (int end=0,start=0;end<len;end++){
            char a = s.charAt(end);//获取s字符串中end位置的字符
            if (map.containsKey(a))//存在以a为key的字符串
                start = Math.max(map.get(a),start);//令头指针为头指针或
            m = Math.max(m,end-start+1);//求map中的a和start中的最大值
            map.put(s.charAt(end),end+1);//入队列
        }
        return m;
    }
    //面试题55 - I. 二叉树的深度
    public int maxDepth(TreeNode root) {
        int sum;
        if (root==null)
            return 0;
        int max_left = maxDepth(root.left);
        int max_right = maxDepth(root.right);
        return Math.max(max_left,max_right)+1;
    }
    //面试题07. 重建二叉树
    //利用原理,先序遍历的第一个节点就是根。在中序遍历中通过根 区分哪些是左子树的，哪些是右子树的
    //左右子树，递归
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();//标记中序遍历
    int[] preorder;//保留的先序遍历
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursive(0,0,inorder.length-1);
    }

    /**
     * @param pre_root_idx  先序遍历的索引
     * @param in_left_idx  中序遍历的索引
     * @param in_right_idx 中序遍历的索引
     */
    public TreeNode recursive(int pre_root_idx, int in_left_idx, int in_right_idx) {
        //相等就是自己
        if (in_left_idx > in_right_idx) {
            return null;
        }
        //root_idx是在先序里面的
        TreeNode root = new TreeNode(preorder[pre_root_idx]);
        // 有了先序的,再根据先序的，在中序中获 当前根的索引
        int idx = map.get(preorder[pre_root_idx]);
        //左子树的根节点就是 左子树的(前序遍历）第一个，就是+1,左边边界就是left，右边边界是中间区分的idx-1
        root.left = recursive(pre_root_idx + 1, in_left_idx, idx - 1);
        //由根节点在中序遍历的idx 区分成2段,idx 就是根
        //右子树的根，就是右子树（前序遍历）的第一个,就是当前根节点 加上左子树的数量
        // pre_root_idx 当前的根  左子树的长度 = 左子树的左边-右边 (idx-1 - in_left_idx +1) 。最后+1就是右子树的根了
        root.right = recursive(pre_root_idx + (idx-1 - in_left_idx +1)  + 1, idx + 1, in_right_idx);
        return root;
    }
    //面试题：16.03 交点，解析https://leetcode-cn.com/problems/intersection-lcci/solution/shi-yong-zhi-xian-xie-jie-shi-fang-cheng-zai-pan-d/

        public double[] intersection(int[] start1_, int[] end1_, int[] start2_, int[] end2_) {

            // 为了避免给后面使用造成不便，修改了入参声明

            Point[] points = checkAndConvertIntoPoint(start1_, end1_, start2_, end2_);
            Point start1 = points[0];
            Point end1 = points[1];
            Point start2 = points[2];
            Point end2 = points[3];

            // 封装成直线类，以便计算斜率和截距
            Line line1 = new Line(start1, end1);
            Line line2 = new Line(start2, end2);

            // 误差精度
            double epslion = 1e-6f;
            // 两条直线的交点（如果存在的话）
            Point intersection;

            // 情况 1：（特殊情况）两条直线有一条斜率为正无穷
            if (line1.k == Integer.MAX_VALUE || line2.k == Integer.MAX_VALUE) {

                // 两条直线斜率都不存在时
                if (line1.k == Integer.MAX_VALUE && line2.k == Integer.MAX_VALUE) {

                    // 这里讨论两条直线重合的情况， b 不是截距的意思，而是表示 x = a 这条线段
                    if (Math.abs(line1.b - line2.b) <= epslion && (isBetween(start1, start2, end1)) || isBetween(start2, start1, end2)) {
                        if (isBetween(start1, start2, end1)) {
                            return new double[]{start2.x, start2.y};
                        } else {
                            return new double[]{start1.x, start1.y};
                        }
                    }
                }

                // 其中一条直线斜率不存在
                if (line1.k == Integer.MAX_VALUE) {
                    intersection = new Point(line1.b, line1.b * line2.k + line2.b);
                } else {
                    intersection = new Point(line2.b, line2.b * line1.k + line1.b);
                }

            } else if (Math.abs(line1.k - line2.k) <= epslion) {
                // 情况 2：（特殊情况）斜率相等的情况下，如果在 y 轴上的截距相等，就表示两条直线重合
                if (Math.abs(line1.b - line2.b) <= epslion && isBetween(start1, start2, end1)) {
                    return new double[]{start2.x, start2.y};
                }
                return new double[0];
            } else {
                // 情况 3：（一般情况）使用公式计算交点的坐标
                double x = (line2.b - line1.b) / (line1.k - line2.k);
                double y = x * line1.k + line1.b;

                intersection = new Point(x, y);
            }

            // 检测所在直线的交点是否在两条线段的横纵坐标范围之内
            if (isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2)) {
                return new double[]{intersection.x, intersection.y};
            }
            return new double[0];
        }


        private Point[] checkAndConvertIntoPoint(int[] start1_, int[] end1_, int[] start2_, int[] end2_) {
            // 封装成 Point 类，将 int 转换成 double 类型，以便于计算
            Point start1 = new Point(start1_[0], start1_[1]);
            Point end1 = new Point(end1_[0], end1_[1]);
            Point start2 = new Point(start2_[0], start2_[1]);
            Point end2 = new Point(end2_[0], end2_[1]);

            // 参数校验：保证横坐标符合约定
            // 对于单条线段而言，起点坐标总是横坐标较小的那一个
            if (start1.x > end1.x) {
                swap(start1, end1);
            }
            if (start2.x > end2.x) {
                swap(start2, end2);
            }

            // 对于两条线段而言，线段 1 的横坐标小于等于线段 2 的横坐标
            if (start1.x > start2.x) {
                // 两条线段交换
                swap(start1, start2);
                swap(end1, end2);
            }
            return new Point[]{start1, end1, start2, end2};
        }

        private boolean isBetween(double start, double middle, double end) {
            if (start > end) {
                // 逆序
                return end <= middle && middle <= start;
            } else {
                // 顺序
                return start <= middle && middle <= end;
            }
        }

        private boolean isBetween(Point start, Point middle, Point end) {
            return isBetween(start.x, middle.x, end.x) && isBetween(start.y, middle.y, end.y);
        }


        /**
         * 交换两个点坐标的数值
         *
         * @param point1
         * @param point2
         */
        private void swap(Point point1, Point point2) {
            double tempX = point1.x;
            double tempY = point1.y;

            point1.x = point2.x;
            point1.y = point2.y;

            point2.x = tempX;
            point2.y = tempY;
        }


        private class Line {
            /**
             * 斜率
             */
            private double k;

            /**
             * 在 y 轴上的截距
             */
            private double b;

            public Line(Point start, Point end) {
                double deltaY = end.y - start.y;
                double deltaX = end.x - start.x;

                // 注意：当 deltaX = 0 的时候，设置斜率为正无穷
                if (deltaX == 0) {
                    k = Integer.MAX_VALUE;
                    // 此时截距为直线在 x 轴上的截距，这里是特殊的做法
                    b = end.x;
                } else {
                    k = deltaY / deltaX;
                    b = end.y - k * end.x;
                }
            }
        }

        /**
         * 将输入封装成 Point，以便把 int 类型转换成 double 类型，便于计算
         */
        private class Point {
            private double x;
            private double y;

            public Point(double x, double y) {
                this.x = x;
                this.y = y;
            }
        }

        public static void main(String[] args) {

//        int[] start1 = new int[]{0, 0};
//        int[] end1 = new int[]{1, 0};
//
//        int[] start2 = new int[]{1, 1};
//        int[] end2 = new int[]{0, -1};

//        int[] start1 = new int[]{0, 0};
//        int[] end1 = new int[]{0, 1};
//
//        int[] start2 = new int[]{0, 0};
//        int[] end2 = new int[]{0, -1};


            int[] start1 = new int[]{0, 0};
            int[] end1 = new int[]{0, 6};

            int[] start2 = new int[]{0, 1};
            int[] end2 = new int[]{0, 5};

            Solution solution = new Solution();
            double[] res = solution.intersection(start1, end1, start2, end2);
            System.out.println(Arrays.toString(res));


        }
}
public class AVLTree {
    public static void main(String[] args) {

    }

    private static final int ALLOWED_BALANCE = 1;

    /**
     * 给指定树节点插入新数据
     *
     * @param data 要插入的数据
     * @param t    指定的树
     * @return 返回插入新数据后的树
     */
    private AvlNode insert(Integer data, AvlNode t) {
        if (t == null) {
            return new AvlNode(data, null, null);
        }
        int result = data - t.data;
        if (result > 0) {
            t.right = insert(data, t.right);
        } else if (result < 0) {
            t.left = insert(data, t.left);
        } else {
            //如果要插入的数据，与当前树的根节点相同则直接返回
            return t;
        }
        return balance(t);
    }

    /**
     * 平衡树并返回结果
     *
     * @param t 要被平衡的树
     * @return 返回平衡后的树
     */
    private AvlNode balance(AvlNode t) {
        if (t == null) {
            return null;
        }
        if (height(t.left) - height(t.right) > ALLOWED_BALANCE) {
            if (height(t.left.left) - height(t.left.right) >= 0) {
                t = rotateWithRight(t);
            } else {
                t = doubleRotateWithRight(t);
            }
        } else if (height(t.right) - height(t.left) > ALLOWED_BALANCE) {
            if (height(t.right.right) - height(t.right.left) >= 0) {
                t = rotateWithLeft(t);
            } else {
                t = doubleRotateWithLeft(t);
            }
        }
        t.height = Math.max(t.left.height, t.right.height) + 1;
        return t;
    }

    private AvlNode rotateWithLeft(AvlNode t) {
        AvlNode temp = t.right;
        t.right = temp.left;
        temp.left = t;
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        temp.height = Math.max(height(temp.right), height(temp.left)) + 1;
        return t;
    }

    private AvlNode rotateWithRight(AvlNode t) {
        AvlNode temp = t.left;
        t.left = temp.right;
        temp.right = t;
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        temp.height = Math.max(height(temp.right), height(temp.left)) + 1;
        return t;
    }

    private AvlNode doubleRotateWithLeft(AvlNode t) {
        t.left = rotateWithLeft(t.left);
        return rotateWithRight(t);
    }

    private AvlNode doubleRotateWithRight(AvlNode t) {
        t.right = rotateWithRight(t.right);
        return rotateWithLeft(t);
    }

    private AvlNode delete(Integer data, AvlNode t) {
        if (t == null) {
            return null;
        }
        int result = data.compareTo(t.data);
        if (result > 0) {
            t.right = delete(data, t.right);
        } else if (result < 0) {
            t.left = delete(data, t.left);
        } else if (t.right != null && t.left != null) {
            t.data = findMin(t.right).data;
            t.right = delete(t.data, t.right);
        } else {
            t = t.left != null ? t.left : t.right;
        }
        return balance(t);
    }

    private AvlNode findMin(AvlNode t) {
        if (t == null) {
            return null;
        }
        if (t.left != null) {
            return findMin(t.left);
        } else {
            return t;
        }
    }

    private Integer height(AvlNode node) {
        return node.height == null ? -1 : node.height;
    }

    public static class AvlNode {
        private Integer data;
        private AvlNode left;
        private AvlNode right;
        //存储左子树或右子树两个数中高度最大的那个值
        private Integer height;

        public AvlNode(Integer data, AvlNode left, AvlNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.height = 0;
        }


    }
}

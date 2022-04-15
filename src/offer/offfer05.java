package offer;

/**
 * @ClassName offfer05
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/15 21:36
 * @Version:1.0
 */
public class offfer05 {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        int length=chars.length;
        char[] chs=new char[length*3];
        int size=0;
        for (int i=0;i<length;++i){
            if (chars[i]==' '){
                chs[size++]='%';
                chs[size++]='2';
                chs[size++]='0';
            }else{
                chs[size++]=chars[i];
            }
        }

        return new String(chs,0, size);
    }
}

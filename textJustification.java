public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new LinkedList<String>();

        for (int i = 0, w; i < words.length; i = w) {
            int len = -1;
            for (w = i; w < words.length && len + words[w].length() + 1 <= maxWidth; w++) {
                len += words[w].length() + 1;
            }

            StringBuilder strBuilder = new StringBuilder(words[i]);
            int space = 1, extra = 0;
            if (w != i + 1 && w != words.length) {
                space = (maxWidth - len) / (w - i - 1) + 1;
                extra = (maxWidth - len) % (w - i - 1);
            }
            for (int j = i + 1; j < w; j++) {
                for (int s = space; s > 0; s--) strBuilder.append(' ');
                if (extra-- > 0) strBuilder.append(' ');
                strBuilder.append(words[j]);
            }
            int strLen = maxWidth - strBuilder.length();
            while (strLen-- > 0) strBuilder.append(' ');
            list.add(strBuilder.toString());
        }

        return list;
    }
}
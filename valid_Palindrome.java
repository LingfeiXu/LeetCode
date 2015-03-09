{
    public boolean isPalindrome(String s) {
        boolean flag = true;
        if(s==null||s.length()==0)
            return true;
        int i = 0;
        int j = s.length() - 1;
        while(i<j) {
            char chi = s.charAt(i);
            char chj = s.charAt(j);
            chi = isAlphanumeric(chi);
            chj = isAlphanumeric(chj);
            if(chi =='F') {
                j++;
            } else if(chj == 'F') {
                i--;
            } else if(chi != chj) {
                return false;
            }
            i++;
            j--;
        }
        if(flag)
            return true;
        return false;
    }
    
    char isAlphanumeric(char chi) {
        if(chi >= 'a' && chi <= 'z'||chi >= '0' && chi <= '9') {
            return chi;
        } else if(chi >= 'A' && chi <= 'Z') {
            return (char)(chi-'A'+'a');
        } else {
            return 'F';
        }
    }
}
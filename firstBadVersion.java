/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n == 1)
            return isBadVersion(1)?1:0;
        return badVersion(1, n);
    }
    
    int badVersion(int first, int end) {
        int mid = first + (end - first)/2;
        if(mid == first)
            return isBadVersion(first)?first:end;
        if(isBadVersion(mid))
            return badVersion(first, mid);
        else
            return badVersion(mid, end);
    }
}

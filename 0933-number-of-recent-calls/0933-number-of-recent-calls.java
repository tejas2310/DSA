class RecentCounter {
    List<Integer> request;
    public RecentCounter() {
        this.request = new ArrayList<>();
    }
    
    public int ping(int t) {
        request.add(t);
        return this.request.size() - getLowerBound(t-3000);
    }

    public int getLowerBound(int lowerRangeTimestamp){
        if(this.request.get(0) >= lowerRangeTimestamp) return 0;
        int start = 0;
        int end = this.request.size() - 1;
        int mid;
        while(start<end){
            mid = start + (end-start)/2;
            if(request.get(mid)>=lowerRangeTimestamp) end = mid;
            else start = mid +1;
        }
        return start;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
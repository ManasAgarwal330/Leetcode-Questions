class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        
        for(String path : paths){
            String[] arr = path.split("/");
            String[] files = arr[arr.length-1].split(" ");
            
            String pth = path.split(" ")[0];
            for(int i=1;i<files.length;i++){
                String text = files[i].split("\\(")[1];
                ArrayList<String> ar = map.getOrDefault(text,new ArrayList<>());
                ar.add(pth+"/"+files[i].split("\\(")[0]);
                map.put(text,ar);
            }
        }
        List<List<String>> ar = new ArrayList<>();
        for(String keys:map.keySet()){
            if(map.get(keys).size() > 1){
                ar.add(map.get(keys));
            }
        }
        // System.out.println(map);
        return ar;
    }
}
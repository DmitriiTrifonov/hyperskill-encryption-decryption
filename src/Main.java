class Main {

    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";
        
        int preModeIndex = getIndex(args, "-mode");
        int preKeyIndex = getIndex(args, "-key");
        int preDataIndex = getIndex(args, "-data");
        
        if (preModeIndex >= 0) {
            mode = args[preModeIndex + 1];
        }
        
        if (preKeyIndex >= 0) {
            key = Integer.valueOf(args[preKeyIndex + 1]);
        }
        
        if (preDataIndex >= 0) {
            data = args[preDataIndex + 1].replace("\"", "");
        }
        
        if (mode.equals("enc") {
            System.out.println(encrypt(data, key));
        } else {
            System.out.println(decrypt(data, key));
        }
        
        
        
    }
    
    static int getIndex(String[] arr, String searchFor) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(searchFor)) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    static String encrypt(String input, int key) {
        return shiftChars(input, key);
    }
    
    static String decrypt(String input, int key) {
        return shiftChars(input, -key);
    }
    
    static String shiftChars(String input, int shift) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            output += String.valueOf((Char)((Int)input.charAt(i) + shift));
        }
        return output;
    }

}

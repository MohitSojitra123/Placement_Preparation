class truncate_Sentence_Question_1816_2 {
    public String  trucate_String(String s, int k) {

        int spaceCount = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                spaceCount++;

                if (spaceCount == k) {
                    return s.substring(0, i);
                }
            }
        }

        return s;
    }
}
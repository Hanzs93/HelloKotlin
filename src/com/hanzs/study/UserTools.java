package com.hanzs.study;

public class UserTools {
    public static String getOriginalInfo(String key, String userId) {
        // �ж�key��userId�Ƿ�Ϊ��
        if (key == null) {
            return null;
        }

        if (userId == null) {
            return null;
        }

        // ���ܵ���Կ����key1:key2���� : �ָ�
        if (!key.contains(":")) {
            return null;
        }

        // ��ȡ�������û��˺�
        String result = "";

        String[] keys = null;
        try {
            keys = key.split(":");

            // ��������ע�⽫keys[0]��keys[1]ת��Ϊint�ͣ�
            char[] use = userId.toCharArray();

            for (int i = 0; i < userId.length(); i++) {
                if ((i + 1) % 2 == 1) {
                    use[i] = (char) (use[i] + Integer.parseInt(keys[1]));
                } else {
                    use[i] = (char) (use[i] - Integer.parseInt(keys[1]));
                }
            }

            for (int i = 0; i < use.length; i++) {
                result += use[i];
            }
        } catch (Exception e) {
            // �쳣����.
        }

        String m1 = result.substring(0,
                result.length() - Integer.parseInt(keys[0]));

        String m2 = result.substring(
                result.length() - Integer.parseInt(keys[0]), result.length());

        int s = 0, e = m1.length() - 1;

        char[] us = m1.toCharArray();

        while (s < e) {
            char temp = us[e];
            us[e] = us[s];
            us[s] = temp;

            s++;
            e--;
        }

        m1 = "";
        for (int i = 0; i < us.length; i++)
            m1 += us[i];

        result = m2 + m1;

        return result;
    }

    public static String encodeInfo(String userId, String key) {
        // �ж�key��userId�Ƿ�Ϊ��
        if (key == null) {
            return null;
        }

        if (userId == null) {
            return null;
        }

        // ���ܵ���Կ����key1:key2���� : �ָ�
        if (!key.contains(":")) {
            return null;
        }

        String[] keys = key.split(":");
        int key1 = Integer.parseInt(keys[0]);
        int key2 = Integer.parseInt(keys[1]);

        String u1 = userId.substring(0, key1);
        String u2 = userId.substring(key1, userId.length());
        int start = 0, end = u2.length() - 1;
        char[] nu2 = u2.toCharArray();
        while (start < end) {
            char temp = nu2[end];
            nu2[end] = nu2[start];
            nu2[start] = temp;
            start++;
            end--;
        }
        u2 = "";
        for (int i = 0; i < nu2.length; i++)
            u2 += nu2[i];
        userId = u2 + u1;
        char[] use = userId.toCharArray();
        for (int i = 0; i < userId.length(); i++) {
            if ((i + 1) % 2 == 1)
                use[i] = (char) (use[i] - key2);
            else
                use[i] = (char) (use[i] + key2);
        }
        userId = "";
        for (int i = 0; i < use.length; i++)
            userId += use[i];
        return userId;
    }
}

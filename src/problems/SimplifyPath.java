package problems;

import java.util.ArrayList;

/**
 * problem 71: Simplify Path
 *
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * Corner Cases:
 *
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class SimplifyPath {
    public String solution(String path) {
        String[] paths = path.split("/+");
        ArrayList<String> pathList = new ArrayList<String>();
        for (String p : paths) {
            if (p.equals("") || p.equals("."))
                continue;

            if (p.equals("..") && !pathList.isEmpty()) {
                pathList.remove(pathList.size()-1);
            } else if (!p.equals("..")) {
                pathList.add(p);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String p : pathList) {
            sb.append("/");
            sb.append(p);
        }

        return pathList.isEmpty() ? "/" : sb.toString();
    }
}

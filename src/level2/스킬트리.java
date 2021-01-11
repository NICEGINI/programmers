/**
 * 
 */
package level2;

/**
 * @author YSM
 *
 */
public class 스킬트리 {
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		int res = 0;
		
		for(int i = 0; i < skill_trees.length; i++) { // 각 스킬 요소만큼 반복
			if(find_skill(skill, skill_trees[i])) {
				res++;
				System.out.println(skill_trees[i]);
			}
		}
		System.out.println(res);
	}

	private static boolean find_skill(String skills, String skillTree) {
		int idx = 0; // 현재 스킬을 가리킬 인덱스
		
		for(int i = 0; i < skillTree.length(); i++) { // 현재 스킬 트리의 길이만큼 반복
			char nextSkill = skillTree.charAt(i);
			for(int j = idx; j < skills.length(); j++) {
				char curSkill = skills.charAt(j);
				if(curSkill == nextSkill) {
					if(j != idx) return false;
					idx++;
					if(idx == skills.length()) return true;
					curSkill = skills.charAt(idx);
					break;
				}
			}
		}
		if(idx == skills.length()-1) return true;
		return false;
	}
}

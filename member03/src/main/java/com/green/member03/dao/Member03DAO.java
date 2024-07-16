package com.green.member03.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.member03.dto.Member03DTO;

@Repository
public class Member03DAO implements IMember03{
	
	@Autowired
	 private SqlSessionTemplate sql;
    
	public int save(Member03DTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        // Member.save : member03Mapper.xml의 namespace인 Memeber과 id인 save를 의미한다. 
        // 결론은 member03Mapper의 insert에 memberDTO를 넘긴다는 의미를 가진다.
        return sql.insert("Member.save", memberDTO);
    }

    public Member03DTO login(Member03DTO memberDTO) {
        return sql.selectOne("Member.login", memberDTO);
    }

    public List<Member03DTO> findAll() {
        return sql.selectList("Member.findAll");
    }

    public Member03DTO findById(Long id) {
        return sql.selectOne("Member.findById", id);
    }

    public void delete(Long id) {
        sql.delete("Member.delete", id);
    }

    public Member03DTO findByMemberEmail(String loginEmail) {
        return sql.selectOne("Member.findByMemberEmail", loginEmail);
    }

    public int update(Member03DTO memberDTO) {
        return sql.update("Member.update", memberDTO);
    }
}

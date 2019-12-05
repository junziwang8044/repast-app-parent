package com.aaa.lee.app.domain;

import javax.persistence.*;

@Table(name = "delete_history_search")
public class PmsCommentRe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "history_search_name")
    private String historySearchName;

    @Column(name = "member_id")
    private Long memberId;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return history_search_name
     */
    public String getHistorySearchName() {
        return historySearchName;
    }

    /**
     * @param historySearchName
     */
    public void setHistorySearchName(String historySearchName) {
        this.historySearchName = historySearchName == null ? null : historySearchName.trim();
    }

    /**
     * @return member_id
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * @param memberId
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
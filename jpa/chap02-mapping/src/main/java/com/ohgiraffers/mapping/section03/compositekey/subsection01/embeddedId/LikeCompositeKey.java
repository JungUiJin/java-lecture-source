package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedId;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class LikeCompositeKey implements Serializable {

    @Column(name = "liked_member_no")
    private int likedMemberNo;

    @Column(name = "liked_book_no")
    private int likedBookNo;

    public LikeCompositeKey() {

    }

    public LikeCompositeKey(int likedMemberNo, int likedBookNo) {
        this.likedMemberNo = likedMemberNo;
        this.likedBookNo = likedBookNo;
    }

}

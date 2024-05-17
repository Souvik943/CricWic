package com.souvik.cricwic.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "cricwick")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long matchId;

    private String matchHeading;

    private String matchInfo;

    private String battingTeam;

    private String battingTeamScore;

    private String fieldingTeam;

    private String fieldingTeamScore;

    private String innings;

    private String matchURL;

    private String matchCompleted;

    @Enumerated
    private MatchStatus matchStatus;

    private Date date = new Date();

    public void setMatchStatus() {
        if(matchCompleted.isBlank()) {
            this.matchStatus = MatchStatus.LIVE;
        }
        else {
            this.matchStatus = MatchStatus.COMPLETED;
        }
    }

}

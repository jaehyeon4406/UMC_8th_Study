package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMissionChallenge is a Querydsl query type for MissionChallenge
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMissionChallenge extends EntityPathBase<MissionChallenge> {

    private static final long serialVersionUID = -575536925L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMissionChallenge missionChallenge = new QMissionChallenge("missionChallenge");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public final QMission mission;

    public final EnumPath<umc.spring.domain.enums.MissionStatus> status = createEnum("status", umc.spring.domain.enums.MissionStatus.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QMissionChallenge(String variable) {
        this(MissionChallenge.class, forVariable(variable), INITS);
    }

    public QMissionChallenge(Path<? extends MissionChallenge> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMissionChallenge(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMissionChallenge(PathMetadata metadata, PathInits inits) {
        this(MissionChallenge.class, metadata, inits);
    }

    public QMissionChallenge(Class<? extends MissionChallenge> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
        this.mission = inits.isInitialized("mission") ? new QMission(forProperty("mission"), inits.get("mission")) : null;
    }

}


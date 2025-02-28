package com.companionly.prototype.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {
    @GetMapping("library")
    public String library() {
        return "layouts/Library/library";
    }

    @GetMapping("anxiety")
    public String anxiety() {
        return "layouts/Library/anxiety";
    }
    @GetMapping("depression")
    public String depression() {
        return "layouts/Library/depression";
    }
    @GetMapping("stress")
    public String stress() {
        return "layouts/Library/stress";
    }
    @GetMapping("disorders")
    public String disorders() {
        return "layouts/Library/disorders";
    }
    @GetMapping("anxiety_reading")
    public String anxiety_reading() {
        return "layouts/Library/anxiety/anxiety_reading";
    }
    @GetMapping("anxiety_exercises")
    public String anxiety_exercises() {
        return "layouts/Library/anxiety/anxiety_exercises";
    }
    @GetMapping("anxiety_videos")
    public String anxiety_videos() {
        return "layouts/Library/anxiety/anxiety_videos";
    }
    @GetMapping("anxiety_article0")
    public String anxiety_article0() {
        return "layouts/Library/anxiety/anxiety.article0";
    }
    @GetMapping("anxiety_article1")
    public String anxiety_article1() {
        return "layouts/Library/anxiety/anxiety.article1";
    }
    @GetMapping("anxiety_article2")
    public String anxiety_article2() {
        return "layouts/Library/anxiety/anxiety.article2";
    }
    @GetMapping("anxiety_article3")
    public String anxiety_article3() {
        return "layouts/Library/anxiety/anxiety.article3";
    }
    @GetMapping("anxiety_article4")
    public String anxiety_article4() {
        return "layouts/Library/anxiety/anxiety.article4";
    }
    @GetMapping("anxiety_exer0")
    public String anxiety_exer0() {
        return "layouts/Library/anxiety/anxiety.exer0";
    }
    @GetMapping("anxiety_exer1")
    public String anxiety_exer1() {
        return "layouts/Library/anxiety/anxiety.exer1";
    } @GetMapping("anxiety_exer2")
    public String anxiety_exer2() {
        return "layouts/Library/anxiety/anxiety.exer2";
    } @GetMapping("anxiety_exer3")
    public String anxiety_exer3() {
        return "layouts/Library/anxiety/anxiety.exer3";
    } @GetMapping("anxiety_exer4")
    public String anxiety_exer4() {
        return "layouts/Library/anxiety/anxiety.exer4";
    }
    @GetMapping("anxiety_vid0")
    public String anxiety_vid0() {
        return "layouts/Library/anxiety/anxiety.vid0";
    }
    @GetMapping("anxiety_vid1")
    public String anxiety_vid1() {
        return "layouts/Library/anxiety/anxiety.vid1";
    }
    @GetMapping("anxiety_vid2")
    public String anxiety_vid2() {
        return "layouts/Library/anxiety/anxiety.vid2";
    }
    @GetMapping("anxiety_vid3")
    public String anxiety_vid3() {
        return "layouts/Library/anxiety/anxiety.vid3";
    }
    @GetMapping("anxiety_vid4")
    public String anxiety_vid4() {
        return "layouts/Library/anxiety/anxiety.vid4";
    }
@GetMapping("stress_reading")
public String stress_reading() {
    return "layouts/Library/stress/stress_reading";
}
@GetMapping("stress_exercises")
public String stress_exercises() {
    return "layouts/Library/stress/stress_exercises";
}
@GetMapping("stress_videos")
public String stress_videos() {
    return "layouts/Library/stress/stress_videos";
}
@GetMapping("stress_article0")
public String stress_article0() {
    return "layouts/Library/stress/stress.article0";
}
@GetMapping("stress_article1")
public String stress_article1() {
    return "layouts/Library/stress/stress.article1";
}
@GetMapping("stress_article2")
public String stress_article2() {
    return "layouts/Library/stress/stress.article2";
}
@GetMapping("stress_article3")
public String stress_article3() {
    return "layouts/Library/stress/stress.article3";
}
@GetMapping("stress_article4")
public String stress_article4() {
    return "layouts/Library/stress/stress.article4";
}
@GetMapping("stress_exer0")
public String stress_exer0() {
    return "layouts/Library/stress/stress.exer0";
}
@GetMapping("stress_exer1")
public String stress_exer1() {
    return "layouts/Library/stress/stress.exer1";
}
@GetMapping("stress_exer2")
public String stress_exer2() {
    return "layouts/Library/stress/stress.exer2";
}
@GetMapping("stress_exer3")
public String stress_exer3() {
    return "layouts/Library/stress/stress.exer3";
}
@GetMapping("stress_exer4")
public String stress_exer4() {
    return "layouts/Library/stress/stress.exer4";
}
@GetMapping("stress_vid0")
public String stress_vid0() {
    return "layouts/Library/stress/stress.vid0";
}
@GetMapping("stress_vid1")
public String stress_vid1() {
    return "layouts/Library/stress/stress.vid1";
}
@GetMapping("stress_vid2")
public String stress_vid2() {
    return "layouts/Library/stress/stress.vid2";
}
@GetMapping("stress_vid3")
public String stress_vid3() {
    return "layouts/Library/stress/stress.vid3";
}
@GetMapping("stress_vid4")
public String stress_vid4() {
    return "layouts/Library/stress/stress.vid4";
}





@GetMapping("depression_reading")
public String depression_reading() {
    return "layouts/Library/depression/depression_reading";
}
@GetMapping("depression_exercises")
public String depression_exercises() {
    return "layouts/Library/depression/depression_exercises";
}
@GetMapping("depression_videos")
public String depression_videos() {
    return "layouts/Library/depression/depression_videos";
}
@GetMapping("depression_article0")
public String depression_article0() {
    return "layouts/Library/depression/depression.article0";
}
@GetMapping("depression_article1")
public String depression_article1() {
    return "layouts/Library/depression/depression.article1";
}
@GetMapping("depression_article2")
public String depression_article2() {
    return "layouts/Library/depression/depression.article2";
}
@GetMapping("depression_article3")
public String depression_article3() {
    return "layouts/Library/depression/depression.article3";
}
@GetMapping("depression_article4")
public String depression_article4() {
    return "layouts/Library/depression/depression.article4";
}
@GetMapping("depression_exer0")
public String depression_exer0() {
    return "layouts/Library/depression/depression.exer0";
}
@GetMapping("depression_exer1")
public String depression_exer1() {
    return "layouts/Library/depression/depression.exer1";
} @GetMapping("depression_exer2")
public String depression_exer2() {
    return "layouts/Library/depression/depression.exer2";
} @GetMapping("depression_exer3")
public String depression_exer3() {
    return "layouts/Library/depression/depression.exer3";
} @GetMapping("depression_exer4")
public String depression_exer4() {
    return "layouts/Library/depression/depression.exer4";
}
@GetMapping("depression_vid0")
public String depression_vid0() {
    return "layouts/Library/depression/depression.vid0";
}
@GetMapping("depression_vid1")
public String depression_vid1() {
    return "layouts/Library/depression/depression.vid1";
}
@GetMapping("depression_vid2")
public String depression_vid2() {
    return "layouts/Library/depression/depression.vid2";
}
@GetMapping("depression_vid3")
public String depression_vid3() {
    return "layouts/Library/depression/depression.vid3";
}
@GetMapping("depression_vid4")
public String depression_vid4() {
    return "layouts/Library/depression/depression.vid4";
}


@GetMapping("misc_reading")
public String misc_reading() {
    return "layouts/Library/misc/misc_reading";
}
@GetMapping("misc_exercises")
public String misc_exercises() {
    return "layouts/Library/misc/misc_exercises";
}
@GetMapping("misc_videos")
public String misc_videos() {
    return "layouts/Library/misc/misc_videos";
}
@GetMapping("misc_article0")
public String misc_article0() {
    return "layouts/Library/misc/misc.article0";
}
@GetMapping("misc_article1")
public String misc_article1() {
    return "layouts/Library/misc/misc.article1";
}
@GetMapping("misc_article2")
public String misc_article2() {
    return "layouts/Library/misc/misc.article2";
}
@GetMapping("misc_article3")
public String misc_article3() {
    return "layouts/Library/misc/misc.article3";
}
@GetMapping("misc_article4")
public String misc_article4() {
    return "layouts/Library/misc/misc.article4";
}
@GetMapping("misc_exer0")
public String misc_exer0() {
    return "layouts/Library/misc/misc.exer0";
}
@GetMapping("misc_exer1")
public String misc_exer1() {
    return "layouts/Library/misc/misc.exer1";
} @GetMapping("misc_exer2")
public String misc_exer2() {
    return "layouts/Library/misc/misc.exer2";
} @GetMapping("misc_exer3")
public String misc_exer3() {
    return "layouts/Library/misc/misc.exer3";
} @GetMapping("misc_exer4")
public String misc_exer4() {
    return "layouts/Library/misc/misc.exer4";
}
@GetMapping("misc_vid0")
public String misc_vid0() {
    return "layouts/Library/misc/misc.vid0";
}
@GetMapping("misc_vid1")
public String misc_vid1() {
    return "layouts/Library/misc/misc.vid1";
}
@GetMapping("misc_vid2")
public String misc_vid2() {
    return "layouts/Library/misc/misc.vid2";
}
@GetMapping("misc_vid3")
public String misc_vid3() {
    return "layouts/Library/misc/misc.vid3";
}
@GetMapping("misc_vid4")
public String misc_vid4() {
    return "layouts/Library/misc/misc.vid4";
}
}

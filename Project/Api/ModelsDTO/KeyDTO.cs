using System;
using System.Collections.Generic;

namespace Api.Models;

public partial class KeyDTO
{
    public string KeyId { get; set; } = null!;

    public int CourseId { get; set; }

    public virtual CourseDTO Course { get; set; } = null!;

    public virtual ICollection<ExamDTO> Exams { get; set; } = new List<ExamDTO>();

    public virtual ICollection<QuestionDTO> Questions { get; set; } = new List<QuestionDTO>();
}

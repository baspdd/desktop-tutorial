using System;
using System.Collections.Generic;
using System.Text.Json.Serialization;

namespace Api.Models;

public partial class ExamAnswer
{
    public int ExamAnswer1 { get; set; }

    public int ExamId { get; set; }

    public string RightRightAnswer { get; set; } = null!;

    [JsonIgnore]
    public virtual Exam? Exam { get; set; } = null!;
}

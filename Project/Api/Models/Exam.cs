using System;
using System.Collections.Generic;
using System.Text.Json.Serialization;

namespace Api.Models;

public partial class Exam
{
    public int ExamId { get; set; }

    public string AccountId { get; set; } = null!;

    public string KeyId { get; set; } = null!;

    public string? Score { get; set; }

    [JsonIgnore]
    public virtual Account? Account { get; set; } = null!;

    public virtual ICollection<ExamAnswer> ExamAnswers { get; set; } = new List<ExamAnswer>();

    [JsonIgnore]
    public virtual Key? Key { get; set; } = null!;
}

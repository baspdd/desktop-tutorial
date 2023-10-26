﻿using Api.Models;
using System;
using System.Collections.Generic;

namespace Api.Models;

public partial class ExamDTO
{
    public int ExamId { get; set; }

    public string AccountId { get; set; } = null!;

    public string KeyId { get; set; } = null!;

    public string? Score { get; set; }

    public virtual ICollection<ExamAnswerDTO> ExamAnswers { get; set; } = new List<ExamAnswerDTO>();

}

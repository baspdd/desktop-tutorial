using System;
using System.Collections.Generic;

namespace Api.Models;

public partial class QuestionDTO
{
    public int QuestionId { get; set; }

    public string KeyId { get; set; } = null!;

    public string Content { get; set; } = null!;

    public string Answer { get; set; } = null!;

    public int NumberRightAnswer { get; set; }

    public virtual KeyDTO Key { get; set; } = null!;

    public virtual ICollection<QuestionAnswerDTO> listAnswer
        => Answer.Split('/').Select(answer => new QuestionAnswerDTO { Content = answer, Ticked = false }).ToList();
}
